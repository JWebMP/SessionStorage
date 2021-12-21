/*
 * Copyright (C) 2017 GedMarc
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.jwebmp.plugins.security.sessionstorage.implementations;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.servlet.RequestScoped;
import com.jwebmp.core.base.ajax.AjaxCall;
import com.jwebmp.core.base.ajax.AjaxResponse;
import com.jwebmp.core.utilities.StaticStrings;
import com.guicedee.guicedinjection.GuiceContext;
import com.jwebmp.interception.services.AjaxCallIntercepter;
import com.jwebmp.interception.services.DataCallIntercepter;
import com.guicedee.logger.LogFactory;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@SuppressWarnings("unused")
public class SessionStorageIntercepter
		implements DataCallIntercepter<SessionStorageIntercepter>,
		           AjaxCallIntercepter<SessionStorageIntercepter>
{
	private static final Logger log = LogFactory.getLog("SessionStorageInterceptor");
	
	@Override
	public void intercept(AjaxCall<?> call, AjaxResponse<?> response)
	{
		/*try
		{
			Map<String, String> sessionStorage = call.getSessionStorage();
			if (call.getVariable(StaticStrings.SESSION_STORAGE_PARAMETER_KEY) != null
					&& !sessionStorage.containsKey(StaticStrings.SESSION_STORAGE_PARAMETER_KEY))
			{
				ObjectMapper mapper = GuiceContext.get(ObjectMapper.class);
				@SuppressWarnings("Convert2Diamond")
				Map<String, String> result = mapper.readValue(call.getVariable(StaticStrings.SESSION_STORAGE_PARAMETER_KEY)
				                                                  .getVariableText(), new TypeReference<Map<String, String>>()
				{
				});
				sessionStorage.put(StaticStrings.SESSION_STORAGE_PARAMETER_KEY, result.get(StaticStrings.SESSION_STORAGE_PARAMETER_KEY));
			}
		}
		catch (Exception e)
		{
			SessionStorageIntercepter.log.log(Level.WARNING, "Unable to check for session storage key", e);
		}*/
	}
	
	@Override
	public Integer sortOrder()
	{
		return -50;
	}
}
