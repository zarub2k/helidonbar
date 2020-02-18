package com.hustlebar.helidonbar.ping;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("/ping")
public interface IPingApi {
    @GET
    @Operation(summary = "Getting started Ping API",
      description = "Just a simple API to ping the system availability")
    @APIResponse(responseCode = "200", description = "Welcome message")
    String ping();

    @GET
    @Path("welcome")
    String welcome(@QueryParam("name") String name);
}
