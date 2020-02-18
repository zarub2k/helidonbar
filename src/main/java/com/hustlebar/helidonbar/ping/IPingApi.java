package com.hustlebar.helidonbar.ping;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("/ping")
public interface IPingApi {
    @GET
    String ping();

    @GET
    @Path("welcome")
    String welcome(@QueryParam("name") String name);
}
