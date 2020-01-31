package net.matiello.multitenant.model;

public interface TenantSupport {

	void setTenantId(String tenantId);

	String getTenantId();
}
