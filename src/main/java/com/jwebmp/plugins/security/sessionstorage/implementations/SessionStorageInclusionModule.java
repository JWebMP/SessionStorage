package com.jwebmp.plugins.security.sessionstorage.implementations;

import com.guicedee.guicedinjection.interfaces.IGuiceScanModuleInclusions;

import java.util.HashSet;
import java.util.Set;

public class SessionStorageInclusionModule implements IGuiceScanModuleInclusions<SessionStorageInclusionModule>
{
    @Override
    public Set<String> includeModules()
    {
        Set<String> set = new HashSet<>();
        set.add("com.jwebmp.plugins.security.sessionstorage");
        return set;
    }
}
