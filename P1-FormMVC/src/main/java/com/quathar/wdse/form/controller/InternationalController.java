package com.quathar.wdse.form.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * <h1>International Controller</h1>
 *
 * @since 2022-11-04
 * @version 1.0
 * @author Q
 */
@Controller
public class InternationalController {

    @GetMapping("/international")
    public String getInternationalPage() {
        return "international";
    }

    @GetMapping("/international-mav")
    public ModelAndView getInternationalPageMAV() {
        return new ModelAndView("international");
    }

}
