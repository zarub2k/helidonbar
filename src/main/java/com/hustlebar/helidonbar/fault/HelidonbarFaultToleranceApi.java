package com.hustlebar.helidonbar.fault;

import com.hustlebar.helidonbar.core.HelidonbarException;
import org.eclipse.microprofile.faulttolerance.Timeout;

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

        Map<String, String> data = new HashMap<>();
        data.put("value", "Response from timeout");

        try {
            Thread.sleep(wait * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return Response.ok()
                .entity(data)
                .build();
    }
}
