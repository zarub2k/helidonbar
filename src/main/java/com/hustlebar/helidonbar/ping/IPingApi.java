package com.hustlebar.helidonbar.ping;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/ping")
public interface IPingApi {
    @GET
    String ping();

    @GET
    @Path("welcome")
    String welcome(@QueryParam("name") String name);
}
