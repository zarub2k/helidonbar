package com.hustlebar.helidonbar.country;

import com.hustlebar.helidonbar.core.HelidonbarException;
import org.eclipse.microprofile.rest.client.RestClientBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.util.List;

public class CountryApiTest {
    static ICountryApi countryApi;
    static final String HOST = "http://localhost:8080";

    @BeforeAll
    public static void initAll() {
        countryApi = RestClientBuilder
                .newBuilder()
                .baseUri(UriBuilder.fromPath(HOST).build())
                .build(ICountryApi.class);
    }

    @Test
    public void testAll() {
        Response response = countryApi.all();
        List<Country> countries = response.readEntity(new GenericType<List<Country>>() {});
        System.out.println(countries);
    }

    @Test
    public void testAdd() throws HelidonbarException {
        Country country = new Country("ITA", "Italy", "Rome");
        Response response = countryApi.add(country);
        System.out.println(response);
        System.out.println(response.getHeaders());
    }

    @Test
    public void testGetWithProperCode() throws HelidonbarException {
        Response response = countryApi.get("USA");
        Country country = response.readEntity(Country.class);
        System.out.println(country);
    }
}
