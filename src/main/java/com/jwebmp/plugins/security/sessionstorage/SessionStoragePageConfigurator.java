package com.jwebmp.plugins.security.sessionstorage;

import com.google.inject.Singleton;
import com.jwebmp.core.base.angular.client.annotations.boot.NgBootConstructorBody;
import com.jwebmp.core.base.angular.client.annotations.boot.NgBootConstructorParameter;
import com.jwebmp.core.plugins.PluginInformation;
import com.jwebmp.core.plugins.PluginStatus;
import com.jwebmp.core.services.IPage;
import com.jwebmp.core.services.IPageConfigurator;

@Singleton
@PluginInformation(pluginName = "Session Storage ",
                   pluginUniqueName = "session-storage",
                   pluginDescription = "Provides access to read and write into the session (per-tab) storage of a browser.",
                   pluginVersion = "1.0",
                   pluginDependancyUniqueIDs = "jquery",
                   pluginCategories = "storage,cookies,local-storage,session-storage",
                   pluginSubtitle = "Session Storage Service ",
                   pluginGitUrl = "https://github.com/JWebMP/SessionStorage",
                   pluginSourceUrl = "https://github.com/JWebMP/SessionStorage",
                   pluginWikiUrl = "https://github.com/JWebMP/SessionStorage/wiki",
                   pluginOriginalHomepage = "https://github.com/JWebMP/SessionStorage",
                   pluginDownloadUrl = "https://mvnrepository.com/artifact/com.jwebmp.plugins/sessionstorage",
                   pluginIconUrl = "",
                   pluginIconImageUrl = "",
                   pluginLastUpdatedDate = "2025/05/10",
                   pluginGroupId = "com.jwebmp.plugins",
                   pluginArtifactId = "sessionstorage",
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
    public IPage<?> configure(IPage<?> page)
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
