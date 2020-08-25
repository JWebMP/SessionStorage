package com.jwebmp.plugins.security.sessionstorage.implementations;

import com.guicedee.guicedservlets.websockets.services.IWebSocketAuthDataProvider;

public class SessionStorageKeyWSAuth
		implements IWebSocketAuthDataProvider<SessionStorageKeyWSAuth>
{
	@Override
	public StringBuilder getJavascriptToPopulate()
	{
		return new StringBuilder("jw.websocket.newMessage('SessionStorage'," +
		                         "{'sessionid':jw.sessionstorage['sessionid']}" +
		                         ");"
		);
	}

	@Override
	public String name()
	{
		return "SessionStorageWS";
	}

	@Override
	public boolean enabled()
	{
		return true;
	}
}
