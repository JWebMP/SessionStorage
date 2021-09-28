package com.jwebmp.plugins.security.sessionstorage.implementations;

import com.google.inject.Inject;
import com.google.inject.Provider;

import java.util.UUID;

public class SessionStorageProvider implements Provider<UUID>
{
	@Inject
	private SessionStorageStringProvider stringProvider;
	
	@Override
	public UUID get()
	{
		return UUID.fromString(stringProvider.get());
	}
}
