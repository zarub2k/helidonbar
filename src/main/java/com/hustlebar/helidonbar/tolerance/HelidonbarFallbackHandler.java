package com.hustlebar.helidonbar.tolerance;

import org.eclipse.microprofile.faulttolerance.ExecutionContext;
import org.eclipse.microprofile.faulttolerance.FallbackHandler;

import javax.ws.rs.core.Response;

public class HelidonbarFallbackHandler implements FallbackHandler<Response> {
    @Override
    public Response handle(ExecutionContext executionContext) {
        return Response
                .ok()
                .entity("Response from HelidonbarFallbackHandler")
                .build();
    }
}
