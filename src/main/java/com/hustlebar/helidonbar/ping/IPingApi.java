package com.hustlebar.helidonbar.ping;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/ping")
public interface IPingApi {
    @GET
    String ping();
}
