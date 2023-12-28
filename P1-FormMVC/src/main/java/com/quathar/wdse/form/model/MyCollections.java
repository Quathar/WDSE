package com.quathar.wdse.form.model;

import java.util.Map;
import java.util.TreeMap;

/**
 * <h1>My Collections</h1>
 *
 * @since 2022-11-04
 * @version 1.0
 * @author Q
 */
public class MyCollections {

    // <<-FIELDS->>
    private static final Map<String, String> listSemaphore = new java.util.LinkedHashMap<>();
    private static final Map<String, String> listCountries = new TreeMap<>();
    private static final Map<String, String> listMusic     = new TreeMap<>();
    private static final Map<String, String> listHobbies   = new TreeMap<>();

    // <<-INIT->>
    static {
        listSemaphore.put("V", "Verde");
        listSemaphore.put("N", "Naranja");
        listSemaphore.put("R", "Rojo");

        listCountries.put("E", "España");
        listCountries.put("F", "Francia");
        listCountries.put("I", "Italia");
        listCountries.put("P", "Portugal");

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
    public static Map<String, String> getListSemaphore() {
        return listSemaphore;
    }

    public static Map<String, String> getListCountries() {
        return listCountries;
    }

    public static Map<String, String> getListMusic() {
        return listMusic;
    }

    public static Map<String, String> getListHobbies() {
        return listHobbies;
    }

}
