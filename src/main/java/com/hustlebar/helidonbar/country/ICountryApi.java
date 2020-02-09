package com.hustlebar.helidonbar.country;

import com.hustlebar.helidonbar.core.HelidonbarException;
import org.eclipse.microprofile.metrics.annotation.Counted;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/countries")
public interface ICountryApi {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Response all();

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Response add(Country country) throws HelidonbarException;

    @GET
    @Path("{code}")
    @Produces(MediaType.APPLICATION_JSON)
    Response get(@PathParam("code") String code) throws HelidonbarException;
}
