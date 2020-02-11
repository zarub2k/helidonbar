package com.hustlebar.helidonbar.fault;

public class HelidonbarFaultToleranceApi implements IHelidonbarFaultToleranceApi {
    @Override
    public void timeout() {
        System.out.println("Enters HelidonbarFaultToleranceApi.timeout()");
    }
}
