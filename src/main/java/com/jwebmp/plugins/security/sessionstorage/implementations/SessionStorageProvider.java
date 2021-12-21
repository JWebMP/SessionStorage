package com.jwebmp.plugins.security.sessionstorage.implementations;

import com.google.common.base.*;
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
		String result = stringProvider.get();
		if(Strings.isNullOrEmpty(result))
		{
			return null;
		}
		return UUID.fromString(result);
	}
}
