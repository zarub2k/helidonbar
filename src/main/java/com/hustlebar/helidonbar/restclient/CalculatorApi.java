package com.hustlebar.helidonbar.restclient;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

@RequestScoped
public class CalculatorApi implements ICalculatorApi {
    @Inject Calculator calculator;

    @Override
    public Response add(long num1, long num2) {
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("result", calculator.add(num1, num2));

        return Response.ok()
                .entity(dataMap)
                .build();
    }

    @Override
    public Response subtract(long num1, long num2) {
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("result", calculator.subtract(num1, num2));

        return Response.ok()
                .entity(dataMap)
                .build();
    }
}
