package com.jwebmp.plugins.security.sessionstorage.implementations;

import com.guicedee.client.services.config.IGuiceScanModuleExclusions;
import com.guicedee.client.services.config.IGuiceScanJarExclusions;
import java.util.LinkedHashSet;
import java.util.Set;

/** SPI services and direct resource access do not require scanning this library. */
public class SessionStorageExclusionModule implements IGuiceScanModuleExclusions<SessionStorageExclusionModule>, IGuiceScanJarExclusions<SessionStorageExclusionModule> {
    @Override public Set<String> excludeModules() { return Set.of("com.jwebmp.plugins.security.sessionstorage"); }
    @Override public Set<String> excludeJars() {
        Set<String> jars = new LinkedHashSet<>();
        jars.add("sessionstorage.jar");
        for (int digit = 0; digit <= 9; digit++) jars.add("sessionstorage-" + digit + "*.jar");
        return jars;
    }
}
