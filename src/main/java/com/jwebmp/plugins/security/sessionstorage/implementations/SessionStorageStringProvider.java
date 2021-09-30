package com.jwebmp.plugins.security.sessionstorage.implementations;

import com.google.inject.Provider;
import com.guicedee.guicedinjection.GuiceContext;
import com.jwebmp.core.base.ajax.AjaxCall;

import java.util.UUID;

import static com.jwebmp.core.htmlbuilder.javascript.events.enumerations.EventTypes.response;
import static com.jwebmp.core.utilities.StaticStrings.SESSION_STORAGE_PARAMETER_KEY;

public class SessionStorageStringProvider implements Provider<String>
{
	@Override
	public String get()
	{
		AjaxCall<?> call = GuiceContext.get(AjaxCall.class);
		com.jwebmp.core.base.ajax.AjaxResponse<?> response = GuiceContext.get(com.jwebmp.core.base.ajax.AjaxResponse.class);
		UUID uuid = null;
		if (call.getSessionStorage()
		        .isEmpty())
		{
			uuid = UUID.randomUUID();
		}
		
		if (call.getSessionStorage()
		        .containsKey(SESSION_STORAGE_PARAMETER_KEY))
		{
			return call.getSessionStorage()
			           .get(SESSION_STORAGE_PARAMETER_KEY);
		}
		if (uuid == null)
		{
			uuid = UUID.randomUUID();
		}
		call.getSessionStorage()
		    .put(SESSION_STORAGE_PARAMETER_KEY, uuid.toString());
		response.getSessionStorage()
		        .put(SESSION_STORAGE_PARAMETER_KEY, uuid.toString());
		
		return uuid.toString();
	}
	
}
