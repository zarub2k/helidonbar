package com.hustlebar.helidonbar.tolerance;

import com.hustlebar.helidonbar.core.HelidonbarException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import java.util.concurrent.Future;

@Path("/tolerance")
public interface IHelidonbarFaultToleranceApi {
    @GET
    @Path("timeout")
    Response timeout(@QueryParam("wait") int wait) throws HelidonbarException;

    @GET
    @Path("timeout-retryOn")
    Response timeoutWithRetryOn(@QueryParam("wait") int wait) throws HelidonbarException;

    @GET
    @Path("timeout-fallback-method")
    Response timeoutWithFallbackMethod(@QueryParam("wait") int wait);

    @GET
    @Path("timeout-fallback-handler")
    Response timeoutWithFallbackHandler(@QueryParam("wait") int wait);

    @GET
    @Path("circuitbreak")
    Response circuitBreak(@QueryParam("wait") int wait);

    @GET
    @Path("/bulkhead")
    Response bulkhead();

    @GET
    @Path("/bulkhead-async")
    Future<Response> bulkheadAsync();
}
