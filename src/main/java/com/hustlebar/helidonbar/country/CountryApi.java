package com.hustlebar.helidonbar.country;

import com.hustlebar.helidonbar.core.HelidonbarException;
import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Metered;
import org.eclipse.microprofile.metrics.annotation.Timed;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@RequestScoped
public class CountryApi implements ICountryApi {
    @Inject CountryManager manager;
    @Context UriInfo uriInfo;

    @Override
    public Response all() {
        return Response.ok()
                .entity(manager.all())
                .build();
    }

    @Override
    public Response add(Country country) throws HelidonbarException {
        String code = manager.add(country);
        Link self = Link.fromPath(uriInfo.getPath() + "/" + code).rel("_self").build();

        return Response.status(Response.Status.fromStatusCode(201))
                .links(self)
                .build();
    }

    @Override
    @Counted(name = "getCountryCount", absolute = true)
    @Metered(name = "getCountryMeter", absolute = true, unit = MetricUnits.MILLISECONDS)
    @Timed(name = "getCountryTimed", absolute = true, unit = MetricUnits.MILLISECONDS)
    public Response get(String code) throws HelidonbarException {
        Country country = manager.get(code);
        return Response.ok()
                .entity(country)
                .build();
    }
}
