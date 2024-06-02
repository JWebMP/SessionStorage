import com.guicedee.guicedinjection.interfaces.IGuiceModule;
import com.jwebmp.plugins.security.sessionstorage.SessionStoragePageConfigurator;
import com.jwebmp.plugins.security.sessionstorage.implementations.SessionStorageSecurityBinder;
import com.jwebmp.plugins.security.sessionstorage.implementations.SessionStorageWSMessageReceiver;

module com.jwebmp.plugins.security.sessionstorage {

    requires transitive com.jwebmp.core.base.angular.client;
    requires com.jwebmp.client;

    requires guiced.vertx.sockets;
    requires static lombok;

    provides com.jwebmp.core.services.IPageConfigurator with SessionStoragePageConfigurator;
    provides com.guicedee.guicedservlets.websockets.services.IWebSocketMessageReceiver with SessionStorageWSMessageReceiver;
    provides IGuiceModule with SessionStorageSecurityBinder;

    exports com.jwebmp.plugins.security.sessionstorage.implementations;
    opens com.jwebmp.plugins.security.sessionstorage.implementations to com.google.guice, com.fasterxml.jackson.databind;
    exports com.jwebmp.plugins.security.sessionstorage;
    opens com.jwebmp.plugins.security.sessionstorage to com.google.guice, com.fasterxml.jackson.databind;
}
