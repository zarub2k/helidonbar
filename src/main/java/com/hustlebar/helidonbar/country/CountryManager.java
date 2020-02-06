package com.hustlebar.helidonbar.country;

import com.hustlebar.helidonbar.core.HelidonbarException;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class CountryManager {
    private static final List<Country> countries = new ArrayList<Country>();
    public List<Country> all() {
        System.out.println("Enters CountryManager.all()");

        return countries;
    }

    public Country get(String code) throws HelidonbarException {
        System.out.println("Enters CountryManager.get() with code: " + code);

        if (code == null || code.isEmpty()) {
            throw new HelidonbarException(404, "Country is not found with the given code");
        }

        Country matchedCountry = null;
        for (Country country : countries) {
            if (country.getCode().equalsIgnoreCase(code)) {
                matchedCountry = country;
            }
        }

        if (matchedCountry == null) {
            throw new HelidonbarException(404, "Country is not found with the given code");
        }

        return matchedCountry;
    }

    static {
        countries.add(new Country("USA", "United States", "Washington D.C."));
        countries.add(new Country("GBR", "United Kingdom", "London"));
        countries.add(new Country("THA", "Thailand", "Bangkok"));
        countries.add(new Country("IND", "India", "New Delhi"));
        countries.add(new Country("ESP", "Spain", "Madrid"));
    }
}
