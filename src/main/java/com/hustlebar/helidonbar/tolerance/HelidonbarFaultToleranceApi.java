package com.hustlebar.helidonbar.tolerance;

import com.hustlebar.helidonbar.core.HelidonbarException;
import com.hustlebar.helidonbar.core.HelidonbarResponseGenerator;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.faulttolerance.exceptions.CircuitBreakerOpenException;
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

        sleep(wait);

        return HelidonbarResponseGenerator.response("Response from timeout");
    }

    @Override
    @Timeout(500)
    @Retry (retryOn = TimeoutException.class)
    public Response timeoutWithRetryOn(int wait) throws HelidonbarException {
        System.out.println("Enters HelidonbarFaultToleranceApi.timeoutWithRetry()");
        sleep(wait);

        return null;
    }

    @Override
    @Timeout(500)
    @Fallback(fallbackMethod = "onFallbackMethod")
    public Response timeoutWithFallbackMethod(int wait) {
        System.out.println("Enters HelidonbarFaultToleranceApi.timeoutWithFallbackMethod() with wait: " + wait);
        sleep(wait);

        return HelidonbarResponseGenerator.response("Response from timeoutWithFallbackMethod()");
    }

    @Override
    @Timeout(500)
    @Fallback(HelidonbarFallbackHandler.class)
    public Response timeoutWithFallbackHandler(int wait) {
        System.out.println("Enters HelidonbarFaultToleranceApi.timeoutWithFallbackHandler() with wait: " + wait);
        sleep(wait);

        return HelidonbarResponseGenerator.response("Response from timeoutWithFallbackHandler()");
    }

    @Override
    @Timeout(500)
    @CircuitBreaker(successThreshold = 2, requestVolumeThreshold = 4, failureRatio=0.75, delay = 1000)
    public Response circuitBreak(int wait) {
        System.out.println("Enters HelibarFaultToleranceApi.circuitBreak()");
        sleep(wait);
        String message = "Response from circuitBreak()";

        return HelidonbarResponseGenerator.response(message);
    }

    private Response onFallbackMethod(int wait) {
        return HelidonbarResponseGenerator.response("Generated from onFallbackMethod()");
    }

    private void sleep(int wait) {
        System.out.println("Forced sleep for " + wait + "min");

        if (wait > 2) {
            try {
                Thread.sleep(wait * 1000);
            } catch (InterruptedException e) {
                System.out.println("Sleep is interrupted");
            }
        }
    }
}
