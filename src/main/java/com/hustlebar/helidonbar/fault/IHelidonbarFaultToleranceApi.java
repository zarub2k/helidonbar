package com.hustlebar.helidonbar.fault;

import com.hustlebar.helidonbar.core.HelidonbarException;
import org.eclipse.microprofile.faulttolerance.Timeout;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/tolerance")
public interface IHelidonbarFaultToleranceApi {
    @GET
    @Path("timeout")
    Response timeout(@QueryParam("wait") int wait) throws HelidonbarException;

    @GET
    @Path("timeout-retry")
    Response timeoutWithRetry(@QueryParam("wait") int wait) throws HelidonbarException;
}
