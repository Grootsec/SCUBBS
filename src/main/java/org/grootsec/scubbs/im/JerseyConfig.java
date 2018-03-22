package org.grootsec.scubbs.im;

import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("/api/v1/im")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(MultiPartFeature.class);
        packages("org.grootsec.scubbs.im.test");
        packages("org.grootsec.scubbs.im.File");
        packages("org.grootsec.scubbs.im.Error");
    }
}