package com.jwebmp.plugins.security.sessionstorage.implementations;

import com.guicedee.guicedservlets.websockets.*;
import com.guicedee.guicedservlets.websockets.options.*;
import com.guicedee.guicedservlets.websockets.services.*;
import com.guicedee.logger.*;
import com.jwebmp.core.base.ajax.*;

import java.util.*;
import java.util.logging.*;

import static com.jwebmp.core.utilities.StaticStrings.*;

public class SessionStorageWSMessageReceiver
		implements IWebSocketMessageReceiver
{
	private static final Logger log = LogFactory.getLog("SessionStorageWSReceiver");
	
	@Override
	public Set<String> messageNames()
	{
		Set<String> messageNames = new HashSet<>();
		messageNames.add("SessionStorage");
		return messageNames;
	}
	
	@Override
	public void receiveMessage(WebSocketMessageReceiver<?> messageReceiver) throws SecurityException
	{
		try
		{
			var session = messageReceiver.getSession();
			if (messageReceiver.getData() != null && messageReceiver.getData()
			                                                        .containsKey(SESSION_STORAGE_PARAMETER_KEY))
			{
				Object o = messageReceiver.getData()
				                          .get(SESSION_STORAGE_PARAMETER_KEY);
				String sessionKey = null;
				if (o == null)
				{
					sessionKey = UUID.randomUUID()
					                 .toString();
					AjaxResponse<?> newKey = new AjaxResponse<>();
					newKey.getSessionStorage()
					      .put(SESSION_STORAGE_TAB_KEY, sessionKey);
					GuicedWebSocket.broadcastMessage(sessionKey, newKey.toString());
				}
				else
				{
					sessionKey = o.toString();
				}
				GuicedWebSocket.addToGroup(sessionKey, session);
				GuicedWebSocket.addWebsocketProperty(session, SESSION_STORAGE_PARAMETER_KEY, sessionKey);
				SessionStorageWSMessageReceiver.log.log(Level.FINER, "Messaging web socket to session - " + sessionKey);
				
				GuicedWebSocket.getWebSocketSessionBindings()
				               .put(sessionKey, session);
			}
			else
			{
				String sessionUUID = UUID.randomUUID()
				                         .toString();
				AjaxResponse<?> newKey = new AjaxResponse<>();
				newKey.getSessionStorage()
				      .put(SESSION_STORAGE_TAB_KEY, sessionUUID);
				GuicedWebSocket.addToGroup(sessionUUID, session);
				GuicedWebSocket.addWebsocketProperty(session, SESSION_STORAGE_PARAMETER_KEY, sessionUUID);
				GuicedWebSocket.getWebSocketSessionBindings()
				               .put(sessionUUID, session);
				GuicedWebSocket.broadcastMessage(sessionUUID, newKey.toString());
			}
		}
		catch (Exception e)
		{
			SessionStorageWSMessageReceiver.log.log(Level.WARNING, "Unable to check for local storage key", e);
		}
		
	}
}