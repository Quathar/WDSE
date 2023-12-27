package com.quathar.form.controller;

import com.quathar.form.model.HttpInfo;
import com.quathar.form.model.MyCollections;
import com.quathar.form.model.Params;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Arrays;

@Controller
@RequestMapping("/form")
public class MyController {

    // <<-FIELD->>
    private final ModelAndView _mAV = new ModelAndView();

    @ModelAttribute
    private void initCollections(Model model, HttpServletRequest request) {
        model.addAttribute("listGenders",   MyCollections.getListGenders());
        model.addAttribute("listCountries", MyCollections.getListCountries());
        model.addAttribute("listMusic",     MyCollections.getListMusic());
        model.addAttribute("listHobbies",   MyCollections.getListHobbies());
        model.addAttribute("httpInfo",      new HttpInfo(request));
    }

    @GetMapping("/get")
    public ModelAndView getForm() {
        // Default values
        Params params = new Params();
        params.setIterations("1");
        params.setName("Lola");
        params.setSelectedCountry("pt");
        params.setPrefix("fr");
        params.setSelectedMusic(Arrays.asList("F", "R"));
        params.setSelectedHobbies(Arrays.asList("D", "P", "V"));

        _mAV.addObject("params", params);
        _mAV.setViewName("form");
        return _mAV;
    }

    @PostMapping("/repaint")
    public ModelAndView repaintForm(
            @Valid Params params,
            BindingResult result
    ) {
        _mAV.addObject("params", params);
        _mAV.setViewName("form");
        return _mAV;
    }

}
