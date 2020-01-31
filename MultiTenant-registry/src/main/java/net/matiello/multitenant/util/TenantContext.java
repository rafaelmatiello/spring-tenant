package net.matiello.multitenant.util;

public class TenantContext {
	
	private static ThreadLocal<String> currentTenant = new ThreadLocal<String>();

	public static String getCurrentTenant() {
		return currentTenant.get();
	}

	public static void setCurrentTenant(String currentTenant) {
		TenantContext.currentTenant.set(currentTenant);
	}

	public static void clear() {
		TenantContext.currentTenant.set(null);
	}
}
