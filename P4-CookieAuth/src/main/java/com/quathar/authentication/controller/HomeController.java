package com.quathar.authentication.controller;

import com.quathar.authentication.controller.helper.HttpHelper;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;

/**
 * <h1>Home Controller</h1>
 *
 * @since 2023-06-26
 * @version 1.0
 * @author Q
 */
@Controller
public class HomeController {

    // <<-CONSTANT->>
    public static final String REDIRECT = "redirect:";
    public static final String USERNAME = "username";

    // <<-METHODS->>
    @GetMapping({"", "/"})
    public ModelAndView redirectAuth(
            HttpServletRequest request,
            RedirectAttributes redirectAttributes
    ) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null)
            return new ModelAndView(REDIRECT + "/auth");

        // TODO: Insert a check on the existing users
        // TODO: Insert a check on the existing users
        // TODO: Insert a check on the existing users
        // && _users.contains(username)
        if (HttpHelper.cookieExists(cookies, HttpHelper.LAST_USER_CONNECTED)) {
            // Here the user enters to his personal area
            String username = HttpHelper.getCookie(cookies, HttpHelper.LAST_USER_CONNECTED).getValue();
            return new ModelAndView("index", Map.of(
                    USERNAME, username
            ));
        }
        if (HttpHelper.cookieExists(cookies, HttpHelper.USERS)) {
            // Here the user has to enter the password
            String[] usersAuthenticated = HttpHelper.getCookie(cookies, HttpHelper.USERS)
                                                    .getValue()
                                                    .split("#");
            String lastUserAuthenticated = usersAuthenticated[usersAuthenticated.length - 1];
            redirectAttributes.addFlashAttribute(USERNAME, lastUserAuthenticated);
            return new ModelAndView(REDIRECT + "/auth/password");
        }

        // Otherwise the user has to authenticate from zero
        return new ModelAndView(REDIRECT + "/auth");
    }

}