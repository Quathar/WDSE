package com.quathar.wdse.authentication.controller;

import com.quathar.wdse.authentication.controller.helper.HttpHelper;
import com.quathar.wdse.authentication.model.dto.LoginDTO;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * <h1>Authentication Controller</h1>
 *
 * @since 2023-02-20
 * @version 2.0
 * @author Q
 */
@Controller
@RequestMapping("/auth")
public class AuthController {

    // <<-CONSTANTS->>
    public static final String REDIRECT  = "redirect:";
    public static final String SECTION   = "section";
    public static final String USERNAME  = "username";
    public static final String LOGIN_DTO = "loginDTO";

    // <<-FIELD->>
    private final Map<String, String> _users = HttpHelper.getUsers();

    // <<-METHODS->>
    @GetMapping("")
    public RedirectView redirectToUsername() {
        return new RedirectView("/auth/username");
    }

    @GetMapping("/username")
    public ModelAndView showUsernameSection() {
        return new ModelAndView("auth", Map.of(
                SECTION,  "USERNAME",
                USERNAME, ""
        ));
    }

    @PostMapping("/username")
    public ModelAndView checkUsername(
            RedirectAttributes redirectAttributes,
            @RequestParam(name = "username") String username
    ) {
        redirectAttributes.addFlashAttribute(USERNAME, username);
        // Check username constraints NotNull and NotBlank
        // and username is on the users Map
        if (username != null && !username.isBlank() && _users.containsKey(username))
             return new ModelAndView(REDIRECT + "/auth/password");
        else return new ModelAndView("auth", Map.of(
                SECTION, "USERNAME",
                USERNAME, username
        ));
    }

    @GetMapping("/password")
    public ModelAndView showPasswordSection(@ModelAttribute(USERNAME) String username) {
        return new ModelAndView("auth", Map.of(
                SECTION,   "PASSWORD",
                LOGIN_DTO, new LoginDTO(username, "")
        ));
    }

    private boolean passwordExists(String username, String password) {
        String storedPassword = _users.get(username);
        return storedPassword != null && storedPassword.equals(password);
    }

    private String setUsersCookie(Cookie[] cookies, String username) {
        if (HttpHelper.cookieExists(cookies, HttpHelper.USERS)) {
            List<String> users = new ArrayList<>(
                    Arrays.asList(HttpHelper.getCookie(cookies, HttpHelper.USERS)
                                            .getValue()
                                            .split("#")));
            if (users.size() > 1) {
                for (int i = 0; i < users.size(); i++)
                    if (users.get(i).equals(username)) {
                        users.remove(users.get(i));
                        break;
                    }
                users.add(username);
            } else if (!users.get(0).equals(username))
                users.add(username);
            return String.join("#", users);
        } else return username;
    }

    private Integer setCountCookie(Cookie[] cookies) {
        if (HttpHelper.cookieExists(cookies, HttpHelper.COUNT)) {
            try {
                String count = HttpHelper.getCookie(cookies, HttpHelper.COUNT)
                                         .getValue();
                return Integer.parseInt(count) + 1;
            } catch (NumberFormatException ignored) {}
        }
        return 1;
    }

    @PostMapping("/password")
    public ModelAndView checkPassword(
            @Valid LoginDTO loginDTO,
            BindingResult bindingResult,
            HttpServletRequest  request,
            HttpServletResponse response,
            RedirectAttributes  redirectAttributes
    ) {
        if (!bindingResult.hasErrors()) {
            if (!passwordExists(loginDTO.getUser(), loginDTO.getPassword()))
                bindingResult.addError(new FieldError(LOGIN_DTO, "password", "Incorrect password"));
            if (!bindingResult.hasErrors()) {
                response.addCookie(HttpHelper.createCookie(HttpHelper.USERS, setUsersCookie(request.getCookies(), loginDTO.getUser())));
                response.addCookie(HttpHelper.createCookie(HttpHelper.LAST_USER_CONNECTED, loginDTO.getUser()));
                response.addCookie(HttpHelper.createCookie(HttpHelper.COUNT, setCountCookie(request.getCookies()) + ""));
                return new ModelAndView(REDIRECT + "/");
            }
        }

        return new ModelAndView("auth", Map.of(
                SECTION, "PASSWORD",
                LOGIN_DTO, loginDTO
        ));
    }

    @PostMapping("/logout")
    public RedirectView logout(
            HttpServletRequest  request,
            HttpServletResponse response,
            RedirectAttributes  redirectAttributes
    ) {
        Cookie[] cookies = request.getCookies();
        if (HttpHelper.cookieExists(cookies, HttpHelper.LAST_USER_CONNECTED)) {
            String lastUserConnected = HttpHelper.getCookie(cookies, HttpHelper.LAST_USER_CONNECTED)
                                                 .getValue();
            redirectAttributes.addFlashAttribute(USERNAME, lastUserConnected);
            response.addCookie(HttpHelper.deleteCookie(HttpHelper.LAST_USER_CONNECTED, "/"));
            return new RedirectView("/auth/password");
        }

        return new RedirectView("/auth/username");
    }

    @GetMapping("/recover")
    public ResponseEntity<String> recoverPassword(String username) {
        String key = _users.get(username);
        return key == null ?
                ResponseEntity.badRequest().build():
                ResponseEntity.ok(key);
    }

}
