package org.grootsec.scubbs.im.test;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Component
@Path("/hello")
public class Endpoint {

    private final Service service;

    public Endpoint(Service service) {
        this.service = service;
    }

    @GET
    public String message() {
        return "Hello " + this.service.message();
    }

}