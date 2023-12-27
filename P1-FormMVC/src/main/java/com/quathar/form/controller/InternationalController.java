package com.quathar.form.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InternationalController {

    @GetMapping("/international")
    public String getMultilanguagePage() {
        return "international";
    }

//    @GetMapping("/international")
//    public ModelAndView getMultilanguagePageMAV() {
//        return new ModelAndView("international");
//    }

}
