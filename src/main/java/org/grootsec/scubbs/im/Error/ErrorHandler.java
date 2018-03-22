package org.grootsec.scubbs.im.Error;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.HashMap;
import java.util.Map;

@Component
@Path("/error")
public class ErrorHandler {
    @GET
    @Produces("application/json")
    public Map<String, Object> errorhandler() {
        Map error = new HashMap<String, Object>();
        error.put("code", "0");
        error.put("Msg", "Unknow");
        return error;
    }
}
