package com.jwebmp.plugins.security.sessionstorage.implementations;

import com.guicedee.guicedinjection.interfaces.IGuiceScanModuleExclusions;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

public class SessionStorageModuleExclusions
		implements IGuiceScanModuleExclusions<SessionStorageModuleExclusions>
{

	@Override
	public @NotNull Set<String> excludeModules()
	{
		Set<String> strings = new HashSet<>();
		strings.add("com.jwebmp.plugins.security.sessionstorage");
		return strings;
	}
}
