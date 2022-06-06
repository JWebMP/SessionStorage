package com.jwebmp.plugins.security.sessionstorage;

import com.google.inject.Singleton;
import com.jwebmp.core.Page;
import com.jwebmp.core.base.angular.client.annotations.boot.*;
import com.jwebmp.core.plugins.PluginInformation;
import com.jwebmp.core.plugins.PluginStatus;
import com.jwebmp.core.services.IPageConfigurator;

import jakarta.validation.constraints.NotNull;

@Singleton
@PluginInformation(pluginName = "Session Storage ",
                   pluginUniqueName = "session-storage",
                   pluginDescription = "Provides access to read and write into the session (per-tab) storage of a browser.",
                   pluginVersion = "1.0",
                   pluginDependancyUniqueIDs = "jquery",
                   pluginCategories = "storage,cookies,local-storage,session-storage",
                   pluginSubtitle = "Session Storage Service ",
                   pluginGitUrl = "https://github.com/GedMarc/JWebMP-SessionStorageSecurity",
                   pluginSourceUrl = "https://github.com/GedMarc/JWebMP-SessionStorageSecurity",
                   pluginWikiUrl = "https://github.com/GedMarc/JWebMP-SessionStorageSecurity/wiki",
                   pluginOriginalHomepage = "https://github.com/GedMarc/JWebMP-SessionStorageSecurity",
                   pluginDownloadUrl = "https://mvnrepository.com/artifact/com.jwebmp.plugins.security/jwebmp-plugins-session-storage-security",
                   pluginIconUrl = "",
                   pluginIconImageUrl = "",
                   pluginLastUpdatedDate = "2022/03/07",
                   pluginGroupId = "com.jwebmp.plugins.security",
                   pluginArtifactId = "jwebmp-plugins-session-storage-security",
                   pluginModuleName = "com.jwebmp.plugins.security.sessionstorage",
                   pluginStatus = PluginStatus.Released
)
@NgBootConstructorParameter("private socketClientService : SocketClientService")
@NgBootConstructorBody(value = "this.socketClientService.send('SessionStorage',{},'sessionStorage');", sortOrder = 105)
public class SessionStoragePageConfigurator
		implements IPageConfigurator<SessionStoragePageConfigurator>
{
	/**
	 * The session storage
	 */
	private boolean sessionStorage = true;
	
	@Override
	public @NotNull Page<?> configure(Page<?> page)
	{
		return page;
	}
	
	@Override
	public boolean enabled()
	{
		return sessionStorage;
	}
	
	
	/**
	 * If this page should be rendered with dynamic local storage support
	 *
	 * @return
	 */
	public boolean isSessionStorage()
	{
		return sessionStorage;
	}
	
	/**
	 * If the page should be rendered with dynamic local storage support. This renders a default page that is then fetched from the server to support cordova applications
	 *
	 * @param sessionStorage
	 */
	public void setSessionStorage(boolean sessionStorage)
	{
		this.sessionStorage = sessionStorage;
	}
}
