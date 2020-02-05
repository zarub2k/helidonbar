package com.hustlebar.helidonbar.ping;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class PingApi implements IPingApi {
    @Override
    public String ping() {
        return "Welcome to Helidon bar!";
    }
}
