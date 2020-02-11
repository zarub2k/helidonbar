package com.hustlebar.helidonbar.fault;

import org.eclipse.microprofile.faulttolerance.Timeout;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/tolerance")
public interface IHelidonbarFaultToleranceApi {
    @GET
    @Timeout
    void timeout();
}
