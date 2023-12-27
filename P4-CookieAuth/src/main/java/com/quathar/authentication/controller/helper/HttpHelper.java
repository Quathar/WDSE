package com.quathar.authentication.controller.helper;

import jakarta.servlet.http.Cookie;

import java.util.HashMap;
import java.util.Map;

/**
 * <h1>Http Helper</h1>
 * <br>
 * This class is created for the purpose of simulating the users to authenticate themselves in the application.
 *
 * @since 2023-02-20
 * @version 1.0
 * @author Q
 */
public class HttpHelper {

    // <<-CONSTANTS->>
    public static final String USERS = "users";
    public static final String LAST_USER_CONNECTED = "last_user_connected";
    public static final String COUNT = "count";

    // <<-FIELD->>
    private static final Map<String, String> users = new HashMap<>();

    // <<-INIT->>
    static {
        // These are the fake users
        // Username :: Password
        users.put("s",         "s");
        users.put("alumno",    "alumno");
        users.put("root",      "root");
        users.put("webmaster", "webmaster");
        users.put("sitesbox",  "sitesbox");
    }

    // <<-METHODS->>
    public static boolean cookieExists(Cookie[] cookies, String name) {
        for (Cookie cookie : cookies)
            if (cookie.getName().equals(name))
                return true;
        return false;
    }

    public static Cookie getCookie(Cookie[] cookies, String name) {
        for (Cookie cookie : cookies)
            if (cookie.getName().equals(name))
                return cookie;
        return null;
    }

    public static Cookie createCookie(String name, String value) {
        return createCookie(name, value, "/", 60 * 60);
    }

    public static Cookie createCookie(String name, String value, String path, int maxAge) {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath(path);
        cookie.setMaxAge(maxAge);
        return cookie;
    }

    public static Cookie deleteCookie(String name, String path) {
        return createCookie(name, "", path, 0);
    }

    // <<-GETTER->>
    public static Map<String, String> getUsers() {
        return users;
    }

}