package com.jwebmp.plugins.security.sessionstorage.implementations;

import com.google.inject.*;
import com.guicedee.client.IGuiceContext;
import com.jwebmp.core.base.ajax.*;

import java.util.*;

import static com.jwebmp.core.utilities.StaticStrings.*;

public class SessionStorageStringProvider implements Provider<String>
{
    @Override
    public String get()
    {
        AjaxCall<?> call = IGuiceContext.get(AjaxCall.class);
        com.jwebmp.core.base.ajax.AjaxResponse<?> response = IGuiceContext.get(com.jwebmp.core.base.ajax.AjaxResponse.class);
        UUID uuid = null;
        if (call.getSessionStorage()
                .isEmpty())
        {
            return null;
        }

        if (call.getSessionStorage()
                .containsKey(SESSION_STORAGE_PARAMETER_KEY))
        {
            return call.getSessionStorage()
                       .get(SESSION_STORAGE_PARAMETER_KEY);
        }

        uuid = UUID.randomUUID();
        call.getSessionStorage()
            .put(SESSION_STORAGE_PARAMETER_KEY, uuid.toString());
        response.getSessionStorage()
                .put(SESSION_STORAGE_PARAMETER_KEY, uuid.toString());

        return uuid.toString();
    }

}
