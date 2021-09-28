package com.jwebmp.plugins.security.sessionstorage.implementations;

import com.google.inject.Provider;
import com.guicedee.guicedinjection.GuiceContext;
import com.jwebmp.core.base.ajax.AjaxCall;

import java.util.UUID;

import static com.jwebmp.core.utilities.StaticStrings.*;

public class SessionStorageStringProvider implements Provider<String>
{
	@Override
	public String get()
	{
		AjaxCall<?> call = GuiceContext.get(AjaxCall.class);
		if (call.getSessionStorage()
		        .isEmpty())
		{
			return UUID.randomUUID()
			           .toString();
		}
		
		return call.getSessionStorage()
		           .get(SESSION_STORAGE_PARAMETER_KEY);
	}
	
}
