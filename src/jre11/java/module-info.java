import com.jwebmp.plugins.security.sessionstorage.SessionStoragePageConfigurator;
import com.jwebmp.plugins.security.sessionstorage.implementations.*;

module com.jwebmp.plugins.security.sessionstorage {

	requires com.jwebmp.core;
	requires jakarta.validation;
	requires com.google.guice;
	requires com.fasterxml.jackson.databind;
	requires com.google.guice.extensions.servlet;
	requires com.guicedee.guicedinjection;
	requires com.jwebmp.interception;
	requires com.guicedee.guicedservlets.websockets;
	requires jakarta.websocket.api;

	provides com.jwebmp.interception.services.DataCallIntercepter with SessionStorageIntercepter;
	provides com.jwebmp.interception.services.AjaxCallIntercepter with SessionStorageIntercepter;
	provides com.jwebmp.core.services.IPageConfigurator with SessionStoragePageConfigurator;
	provides com.jwebmp.core.events.IEventConfigurator with SessionStorageEventConfigurator;
	provides com.guicedee.guicedservlets.websockets.services.IWebSocketAuthDataProvider with SessionStorageKeyWSAuth;
	provides com.guicedee.guicedinjection.interfaces.IGuiceScanModuleExclusions with SessionStorageModuleExclusions;
	provides com.guicedee.guicedservlets.websockets.services.IWebSocketService with SessionStorageWSMessageReceiver;

	opens com.jwebmp.plugins.security.sessionstorage.implementations to com.google.guice,com.fasterxml.jackson.databind;
	opens com.jwebmp.plugins.security.sessionstorage to com.google.guice,com.fasterxml.jackson.databind;
}
