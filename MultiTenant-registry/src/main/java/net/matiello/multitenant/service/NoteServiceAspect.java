package net.matiello.multitenant.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import net.matiello.multitenant.util.TenantContext;

@Component
@Aspect
public class NoteServiceAspect {

	@Before("execution(* net.matiello.multitenant.service.NoteService.*(..)) && target(noteService)")
	public void arroundExecution(JoinPoint join, NoteService noteService) {

		Filter filter = noteService.entityManager.unwrap(Session.class).enableFilter("tenantFilter");
		filter.setParameter("tenantId", TenantContext.getCurrentTenant());
		filter.validate();

	}
}
