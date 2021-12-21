import com.guicedee.guicedinjection.interfaces.IGuiceModule;
import com.jwebmp.plugins.security.sessionstorage.SessionStoragePageConfigurator;
import com.jwebmp.plugins.security.sessionstorage.implementations.*;

module com.jwebmp.plugins.security.sessionstorage {

	requires com.jwebmp.core;
	requires jakarta.validation;
	requires com.google.guice;
	requires com.fasterxml.jackson.databind;
	requires com.google.guice.extensions.servlet;
	requires com.guicedee.guicedinjection;
	requires com.guicedee.guicedservlets.websockets;
	requires jakarta.websocket.api;

	provides com.jwebmp.core.services.IPageConfigurator with SessionStoragePageConfigurator;
	provides com.jwebmp.core.events.IEventConfigurator with SessionStorageEventConfigurator;
	provides com.jwebmp.interception.services.AjaxCallIntercepter with SessionStorageIntercepter;
//	provides com.jwebmp.interception.services.DataCallIntercepter with SessionStorageIntercepter;
	provides com.guicedee.guicedservlets.websockets.services.IWebSocketAuthDataProvider with SessionStorageKeyWSAuth;
	provides com.guicedee.guicedservlets.websockets.services.IWebSocketMessageReceiver with SessionStorageWSMessageReceiver;
//	provides com.guicedee.guicedinjection.interfaces.IGuiceScanModuleInclusions with SessionStorageInclusionModule;
	provides IGuiceModule with SessionStorageSecurityBinder;
	
	exports com.jwebmp.plugins.security.sessionstorage.implementations;
	opens com.jwebmp.plugins.security.sessionstorage.implementations to com.google.guice,com.fasterxml.jackson.databind;
	exports com.jwebmp.plugins.security.sessionstorage;
	opens com.jwebmp.plugins.security.sessionstorage to com.google.guice,com.fasterxml.jackson.databind;
}
