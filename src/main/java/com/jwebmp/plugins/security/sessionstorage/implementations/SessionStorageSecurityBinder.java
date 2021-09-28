package com.jwebmp.plugins.security.sessionstorage.implementations;

import com.google.inject.Key;
import com.google.inject.PrivateModule;
import com.google.inject.name.Names;
import com.guicedee.guicedinjection.interfaces.IGuiceModule;
import com.guicedee.guicedservlets.services.scopes.CallScope;

import java.util.UUID;

public class SessionStorageSecurityBinder extends PrivateModule implements IGuiceModule<SessionStorageSecurityBinder>
{
	@Override
	protected void configure()
	{
		Key<UUID> sessionstoragekey = Key.get(UUID.class, Names.named("sessionstorage"));
		bind(sessionstoragekey).toProvider(SessionStorageProvider.class)
		                     .in(CallScope.class);
		
		expose(sessionstoragekey);
		
		Key<String> sessionstoragekeyString = Key.get(String.class, Names.named("sessionstorage"));
		bind(sessionstoragekeyString).toProvider(SessionStorageStringProvider.class)
		                           .in(CallScope.class);
		
		expose(sessionstoragekeyString);
	}
}
