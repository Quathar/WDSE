package org.quathar.cookies.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Random;

@Controller
@RequestMapping("/cookies")
public class CookiesController {

    // <<-CONSTANT->>
    private static final String UID = "UID";

    // <<-FIELDS->>
    private final ModelAndView _mAV = new ModelAndView();

    // <<-METHODS->>
    private Cookie createUIDCookie(int length) {
        final String values = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();

        StringBuilder value = new StringBuilder();
        for (int i = 0; i < length; i++)
            value.append(values.charAt(random.nextInt(values.length())));

        return new Cookie(UID, value.toString());
    }

    @GetMapping("/home")
    public ModelAndView createCookie(
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            _mAV.addObject("cookies", true);
            _mAV.addObject(UID, cookies[0].getValue());
        } else response.addCookie(createUIDCookie(10));

        _mAV.setViewName("index");
        return _mAV;
    }

}
