package com.hustlebar.helidonbar.restclient;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/calculator")
@RegisterRestClient(baseUri = "http://localhost:8080")
public interface ICalculatorApi {
    @GET
    @Path("add")
    Response add(@QueryParam("num1") long num1, @QueryParam("num2") long num2);

    @GET
    @Path("subtract")
    Response subtract(@QueryParam("num1") long num1, @QueryParam("num2") long num2);
}
