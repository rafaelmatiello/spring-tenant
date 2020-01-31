package net.matiello.multitenant.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

@Component
public class TenantFilter implements Filter {

	private static final String X_TENANT = "X-Tenant";

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		String tHeader = req.getHeader(X_TENANT);

		if (tHeader != null && !tHeader.isEmpty()) {
			TenantContext.setCurrentTenant(tHeader);

		} else {
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}

		chain.doFilter(request, response);
	}

}
