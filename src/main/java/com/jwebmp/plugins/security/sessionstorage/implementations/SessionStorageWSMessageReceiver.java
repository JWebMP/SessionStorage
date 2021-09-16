package com.jwebmp.plugins.security.sessionstorage.implementations;

import com.guicedee.guicedservlets.websockets.GuicedWebSocket;
import com.guicedee.guicedservlets.websockets.options.WebSocketMessageReceiver;
import com.guicedee.guicedservlets.websockets.services.IWebSocketService;
import com.guicedee.logger.LogFactory;
import com.jwebmp.core.base.ajax.AjaxResponse;
import jakarta.websocket.Session;

import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.jwebmp.core.utilities.StaticStrings.*;

public class SessionStorageWSMessageReceiver
		implements IWebSocketService
{
	private static final Logger log = LogFactory.getLog("SessionStorageWSReceiver");
	private static boolean enabled = true;
	
	public static boolean isEnabled()
	{
		return enabled;
	}
	
	public static void setEnabled(boolean enabled)
	{
		SessionStorageWSMessageReceiver.enabled = enabled;
	}
	
	@Override
	public void onOpen(Session session, GuicedWebSocket socket)
	{
	
	}
	
	@Override
	public void onClose(Session session, GuicedWebSocket socket)
	{
	
	}
	
	@Override
	public void onMessage(String message, Session session, WebSocketMessageReceiver messageReceiver, GuicedWebSocket socket)
	{
		if (enabled())
		{
			if (messageReceiver.getAction()
			                   .equalsIgnoreCase("SessionStorage"))
			{
				try
				{
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
	}
	
	@Override
	public void onError(Throwable t, GuicedWebSocket socket)
	{
	}
	
	@Override
	public boolean enabled()
	{
		return SessionStorageWSMessageReceiver.enabled;
	}
}
