package com.jwebmp.plugins.security.sessionstorage.implementations;

import com.jwebmp.core.Event;
import com.jwebmp.core.events.IEventConfigurator;

import jakarta.validation.constraints.NotNull;

import static com.jwebmp.core.utilities.StaticStrings.*;

public class SessionStorageEventConfigurator implements IEventConfigurator<SessionStorageEventConfigurator>
{
	@Override
	public @NotNull Event<?, ?> configureEvent(Event event)
	{
		event.returnVariable(SESSION_STORAGE_VARIABLE_KEY);
		return event;
	}
}
