package com.quathar.wdse.form.model;

import java.util.Map;
import java.util.TreeMap;

// Lombook cannot be used here (update: idk, at least that's what I thought when I did this)
/**
 * <h1>My Collections</h1>
 *
 * @since 2023-12-09
 * @version 1.0
 * @author Q
 */
public class MyCollections {

    // <<-FIELDS->>
    private static final Map<String, String> listGenders    = new TreeMap<>();
    private static final Map<String, Country> listCountries = new TreeMap<>();
    private static final Map<String, String> listMusic      = new TreeMap<>();
    private static final Map<String, String> listHobbies    = new TreeMap<>();

    // <<-INIT->>
    static {
        listGenders.put("F", "Femenino");
        listGenders.put("M", "Masculino");
        listGenders.put("O", "Otro");

        listCountries.put("es", new Country("España", "Castellano", "34", true, "espania.jpg"));
        listCountries.put("fr", new Country("Francia", "Francés", "33", false, "francia.jpg"));
        listCountries.put("it", new Country("Italia", "Italiano", "39", false, "italia.jpg"));
        listCountries.put("pt", new Country("Portugal", "Portugués", "351", false, "portugal.jpg"));
        listCountries.put("en", new Country("Reino Unido", "Inglés", "44", true, "reino_unido.jpg"));

        listMusic.put("E", "Electrónica");
        listMusic.put("F", "Funky");
        listMusic.put("N", "New Age");
        listMusic.put("P", "Pop");
        listMusic.put("R", "Rock");

        listHobbies.put("D", "Deporte");
        listHobbies.put("L", "Lectura");
        listHobbies.put("P", "Pintura");
        listHobbies.put("V", "Viajes");
    }

    // <<-GETTERS->>
    public static Map<String, String> getListGenders() {
        return listGenders;
    }

    public static Map<String, Country> getListCountries() {
        return listCountries;
    }

    public static Map<String, String> getListMusic() {
        return listMusic;
    }

    public static Map<String, String> getListHobbies() {
        return listHobbies;
    }

}
