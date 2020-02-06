package com.hustlebar.helidonbar.country;

import com.hustlebar.helidonbar.core.HelidonbarException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@RequestScoped
public class CountryApi implements ICountryApi {
    @Inject CountryManager manager;

    @Override
    public Response all() {
        return Response.ok()
                .entity(manager.all())
                .build();
    }

    @Override
    public Response get(String code) throws HelidonbarException {
        Country country = manager.get(code);
        return Response.ok()
                .entity(country)
                .build();
    }
}
