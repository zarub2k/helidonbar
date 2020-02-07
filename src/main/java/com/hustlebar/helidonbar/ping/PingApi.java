package com.hustlebar.helidonbar.ping;

import org.eclipse.microprofile.config.Config;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.text.MessageFormat;

@RequestScoped
public class PingApi implements IPingApi {
    @Inject Config config;

    @Override
    public String ping() {
        return "Welcome to Helidon bar!";
    }

    @Override
    public String welcome(String name) {
        String welcomeValue = config.getValue("app.welcome", String.class);

        String formattedValue = MessageFormat.format(welcomeValue, name);
        return formattedValue;
    }
}
