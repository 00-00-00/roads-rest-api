package com.ground0.rest.util;

import com.ground0.rest.service.Service;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * Created by zer0 on 3/2/17.
 */
public class ResourceConfiguration extends ResourceConfig {
    public ResourceConfiguration() {
        packages("com.ground0.rest");
        register(Service.class);
    }
}
