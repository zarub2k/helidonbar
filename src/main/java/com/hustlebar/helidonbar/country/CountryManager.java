package com.hustlebar.helidonbar.country;

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

    static {
        countries.add(new Country("USA", "United States", "Washington D.C."));
        countries.add(new Country("GBR", "United Kingdom", "London"));
        countries.add(new Country("THA", "Thailand", "Bangkok"));
        countries.add(new Country("IND", "India", "New Delhi"));
        countries.add(new Country("ESP", "Spain", "Madrid"));
    }
}
