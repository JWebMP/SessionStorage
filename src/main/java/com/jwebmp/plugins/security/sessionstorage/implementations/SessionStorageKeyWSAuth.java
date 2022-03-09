package com.jwebmp.plugins.security.sessionstorage.implementations;

import com.guicedee.guicedservlets.websockets.services.*;

public class SessionStorageKeyWSAuth
		implements IWebSocketAuthDataProvider<SessionStorageKeyWSAuth>
{
	@Override
	public StringBuilder getJavascriptToPopulate()
	{
		StringBuilder sb = new StringBuilder();
		//sb.append("alert('sending local storage');" +
		sb.append("this.send('SessionStorage',{},'sessionStorage');");
		return sb;
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
