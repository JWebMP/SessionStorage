import com.jwebmp.plugins.security.sessionstorage.SessionStoragePageConfigurator;
import com.jwebmp.plugins.security.sessionstorage.implementations.SessionStorageSecurityBinder;
import com.jwebmp.plugins.security.sessionstorage.implementations.SessionStorageWSMessageReceiver;
import com.jwebmp.plugins.security.sessionstorage.implementations.SessionStorageInclusionModule;

module com.jwebmp.plugins.security.sessionstorage {

    requires transitive com.jwebmp.core.base.angular.client;
    requires com.jwebmp.client;
    requires com.jwebmp.core;
    requires com.jwebmp.vertx;

    requires static lombok;

    provides com.jwebmp.core.services.IPageConfigurator with SessionStoragePageConfigurator;
    provides com.guicedee.client.services.websocket.IWebSocketMessageReceiver with SessionStorageWSMessageReceiver;
    provides com.guicedee.client.services.lifecycle.IGuiceModule with SessionStorageSecurityBinder;
    provides com.guicedee.client.services.config.IGuiceScanModuleInclusions with SessionStorageInclusionModule;

    exports com.jwebmp.plugins.security.sessionstorage.implementations;
    opens com.jwebmp.plugins.security.sessionstorage.implementations to com.google.guice, com.fasterxml.jackson.databind, com.jwebmp.core, com.jwebmp.core.angular;
    exports com.jwebmp.plugins.security.sessionstorage;
    opens com.jwebmp.plugins.security.sessionstorage to com.google.guice, com.fasterxml.jackson.databind, com.jwebmp.core, com.jwebmp.core.angular;
}
