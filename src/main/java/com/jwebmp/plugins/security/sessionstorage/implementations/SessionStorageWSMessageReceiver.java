package com.jwebmp.plugins.security.sessionstorage.implementations;

import com.guicedee.guicedservlets.websockets.GuicedWebSocket;
import com.guicedee.guicedservlets.websockets.options.WebSocketMessageReceiver;
import com.guicedee.guicedservlets.websockets.services.IWebSocketMessageReceiver;
import com.jwebmp.core.base.ajax.AjaxResponse;
import lombok.extern.java.Log;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.logging.Level;

import static com.jwebmp.core.utilities.StaticStrings.SESSION_STORAGE_PARAMETER_KEY;
import static com.jwebmp.core.utilities.StaticStrings.SESSION_STORAGE_TAB_KEY;

@Log
public class SessionStorageWSMessageReceiver
				implements IWebSocketMessageReceiver
{
	
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
			Map<String, Object> map = messageReceiver.getData();
			boolean found = false;
			if (map.containsKey("sessionStorage"))
			{
				Map<String, Object> localStorage = (Map<String, Object>) map.get("sessionStorage");
				if (localStorage.containsKey(SESSION_STORAGE_PARAMETER_KEY))
				{
					Object o = localStorage.get(SESSION_STORAGE_PARAMETER_KEY);
					String sessionKey = null;
					if (o == null)
					{
						sessionKey = UUID.randomUUID()
										.toString();
						AjaxResponse<?> newKey = new AjaxResponse<>();
						newKey.getSessionStorage()
										.put(SESSION_STORAGE_TAB_KEY, sessionKey);
						GuicedWebSocket.broadcastMessage(sessionKey, newKey.toString());
					} else
					{
						sessionKey = o.toString();
					}
					GuicedWebSocket.addToGroup(sessionKey, session);
					GuicedWebSocket.addWebsocketProperty(session, SESSION_STORAGE_PARAMETER_KEY, sessionKey);
					SessionStorageWSMessageReceiver.log.log(Level.FINER, "Messaging web socket to session - " + sessionKey);
					GuicedWebSocket.getWebSocketSessionBindings()
									.put(sessionKey, session);
					found = true;
				}
			}
			
			if (!found)
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
		} catch (Exception e)
		{
			SessionStorageWSMessageReceiver.log.log(Level.WARNING, "Unable to check for local storage key", e);
		}
		
	}
}