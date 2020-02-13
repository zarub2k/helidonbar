package com.hustlebar.helidonbar.tolerance;

import com.hustlebar.helidonbar.core.HelidonbarException;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.faulttolerance.exceptions.TimeoutException;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

@RequestScoped
public class HelidonbarFaultToleranceApi implements IHelidonbarFaultToleranceApi {
    @Override
    @Timeout
    public Response timeout(int wait) throws HelidonbarException {
        System.out.println("Enters HelidonbarFaultToleranceApi.timeout()");

        try {
            Thread.sleep(wait * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return response("Response from timeout");
    }

    @Override
    @Timeout(500)
    @Retry (retryOn = TimeoutException.class)
    public Response timeoutWithRetryOn(int wait) throws HelidonbarException {
        System.out.println("Enters HelidonbarFaultToleranceApi.timeoutWithRetry()");

        try {
            Thread.sleep(wait * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    @Timeout(500)
    public Response timeoutWithFallbackMethod(int wait) {
        System.out.println("Enters HelidonbarFaultToleranceApi.timeoutWithFallbackMethod() with wait: " + wait);

        if (wait > 2) {
            try {
                Thread.sleep(wait * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        return null;
    }

    private Response response(String message) {
        Map<String, String> data = new HashMap<>();
        data.put("value", message);

        return Response.ok()
                .entity(data)
                .build();
    }
}
