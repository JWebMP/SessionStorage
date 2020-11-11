package com.jwebmp.plugins.security.sessionstorage;

import com.google.inject.Singleton;
import com.jwebmp.core.Page;
import com.jwebmp.core.services.IPageConfigurator;

import jakarta.validation.constraints.NotNull;

@Singleton
public class SessionStoragePageConfigurator
		implements IPageConfigurator<SessionStoragePageConfigurator>
{
	/**
	 * The session storage
	 */
	private boolean sessionStorage = true;

	@Override
	public @NotNull Page<?> configure(Page<?> page)
	{
		return page;
	}

	@Override
	public boolean enabled()
	{
		return sessionStorage;
	}


	/**
	 * If this page should be rendered with dynamic local storage support
	 *
	 * @return
	 */
	public boolean isSessionStorage()
	{
		return sessionStorage;
	}

	/**
	 * If the page should be rendered with dynamic local storage support. This renders a default page that is then fetched from the server to support cordova applications
	 *
	 * @param sessionStorage
	 */
	public void setSessionStorage(boolean sessionStorage)
	{
		this.sessionStorage = sessionStorage;
	}
}
