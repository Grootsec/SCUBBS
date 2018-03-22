package org.grootsec.scubbs.im;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        packages("org.grootsec.scubbs.im.test");
    }

}