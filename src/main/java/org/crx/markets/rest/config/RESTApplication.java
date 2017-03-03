package org.crx.markets.rest.config;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath(value = "rest")
public class RESTApplication extends Application {

    private final Set<Class<?>> empty = new HashSet<>();
    private final Set<Object> singletons = new HashSet<>();

    @Override
    public final Set<Class<?>> getClasses() {
        return empty;
    }

    @Override
    public final Set<Object> getSingletons() {
        return singletons;
    }

}