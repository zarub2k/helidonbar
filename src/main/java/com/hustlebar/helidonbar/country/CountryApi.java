package com.hustlebar.helidonbar.country;

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
}
