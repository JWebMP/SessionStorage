package com.jwebmp.plugins.security.sessionstorage.implementations;

import com.jwebmp.core.Event;
import com.jwebmp.core.events.IEventConfigurator;
import com.jwebmp.core.utilities.StaticStrings;

import javax.validation.constraints.NotNull;

public class SessionStorageEventConfigurator implements IEventConfigurator<SessionStorageEventConfigurator>
{
	@Override
	public @NotNull Event<?, ?> configureEvent(Event event)
	{
		event.returnVariable(StaticStrings.SESSION_STORAGE_PARAMETER_KEY);
		return event;
	}
}
