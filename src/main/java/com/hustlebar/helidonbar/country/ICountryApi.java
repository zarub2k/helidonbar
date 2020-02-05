package com.hustlebar.helidonbar.country;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/countries")
public interface ICountryApi {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Response all();
}
