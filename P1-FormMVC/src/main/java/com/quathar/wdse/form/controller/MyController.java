package com.quathar.wdse.form.controller;

import com.quathar.wdse.form.model.MyCollections;
import com.quathar.wdse.form.model.MyParams;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

/**
 * <h1>My Controller</h1>
 *
 * @since 2022-11-04
 * @version 1.0
 * @author Q
 */
@Controller
@RequestMapping("/form")
public class MyController {

    // <<-FIELD->>
    private final ModelAndView _mAV = new ModelAndView();

    // <<-METHODS->>
    @ModelAttribute
    private void initCollections(Model model) {
        model.addAttribute("listSemaphore", MyCollections.getListSemaphore());
        model.addAttribute("listCountries", MyCollections.getListCountries());
        model.addAttribute("listMusic",     MyCollections.getListMusic());
        model.addAttribute("listHobbies",   MyCollections.getListHobbies());
    }

    // <<-FORM WITH MODEL OBJECTS->>
    @GetMapping("/get")
    public ModelAndView getForm() {
        _mAV.addObject("original", true);

        // Default values
        _mAV.addObject("name",            "Pepe");
        _mAV.addObject("iterations",      1);
        _mAV.addObject("selectedCountry", "I");
        _mAV.addObject("selectedMusic",   Arrays.asList("F", "R"));
        _mAV.addObject("selectedHobbies", Arrays.asList("D", "P", "V"));

        // If u want to add more default values, uncomment the line
//        mAV.addObject("passwd", "");
//        mAV.addObject("confirmPasswd", "");
//        mAV.addObject("selectedSemaphore", "");
//        mAV.addObject("document", "");
//        mAV.addObject("comments", "");
//        mAV.addObject("license", "");
//        mAV.addObject("iconX", "");
//        mAV.addObject("iconY", "");

        _mAV.setViewName("index");
        return _mAV;
    }

    private int count(List<String> params, List<String> selectedMusic, List<String> selectedHobbies) {
        int counter = 0;
        for (String param : params)
            if (param != null)
                counter++;
        if (selectedMusic != null)
            counter++;
        if (selectedHobbies != null)
            counter++;
        return counter;
    }

    @PostMapping("/repainted")
    public ModelAndView repaintForm(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String passwd,
            @RequestParam(required = false) String confirmPasswd,
            @RequestParam(required = false) String iterations,
            @RequestParam(required = false) String selectedSemaphore,
            @RequestParam(required = false) String selectedCountry,
            @RequestParam(required = false) String document,
            @RequestParam(required = false) List<String> selectedMusic,
            @RequestParam(required = false) List<String> selectedHobbies,
            @RequestParam(required = false) String comments,
            @RequestParam(required = false) String license,
            @RequestParam(required = false, name = "icon.x") String iconX,
            @RequestParam(required = false, name = "icon.y") String iconY
    ) {
        _mAV.addObject("original", false);

        // DO NOT CHANGE TO List.of() CAUSE IS INMUTABLE
        List<String> params = Arrays.asList(
                name,
                passwd,
                confirmPasswd,
                iterations,
                selectedSemaphore,
                selectedCountry,
                document,
                comments,
                license,
                iconX,
                iconY
        );
        int counter = this.count(params, selectedMusic, selectedHobbies);

        _mAV.addObject("name",              name);
        _mAV.addObject("passwd",            passwd);
        _mAV.addObject("confirmPasswd",     confirmPasswd);
        _mAV.addObject("iterations",        iterations != null ? Integer.parseInt(iterations) + 1 : 1);
        _mAV.addObject("selectedSemaphore", selectedSemaphore);
        _mAV.addObject("selectedCountry",   selectedCountry);
        _mAV.addObject("document",          document);
        _mAV.addObject("selectedMusic",     selectedMusic != null ? selectedMusic: "");
        _mAV.addObject("selectedHobbies",   selectedHobbies != null ? selectedHobbies : "");
        _mAV.addObject("comments",          comments);
        _mAV.addObject("license",           license);
        _mAV.addObject("iconX",             iconX);
        _mAV.addObject("iconY",             iconY);

        _mAV.addObject("total", String.format("%d parameters have been received from the original form", counter));

        _mAV.setViewName("index");
        return _mAV;
    }

    // <<-FORM WITH JAVA OBJECT (PARAMS)->>
    @GetMapping("/get-advanced")
    public ModelAndView getFormAdvanced() {
        MyParams params = new MyParams();

        // Default values
        params.setName("Pepe");
        params.setIterations("0"); // Luego se coloca 1 correctamente (en MyParams)
        params.setSelectedCountry("I");
        params.setSelectedMusic(Arrays.asList("F", "R"));
        params.setSelectedHobbies(Arrays.asList("D", "P", "V"));
//        params.setCounter("0");

        // Si se desea añadir algún valor por defecto a los campos restantes 'uncomment'
//        params.setPasswd("");
//        params.setConfirmPasswd("");
//        params.setSelectedSemaphore("");
//        params.setDocument("");
//        params.setComments("");
//        params.setLicense("");
//        params.setIconX("");
//        params.setIconY("");

        _mAV.addObject("params", params);

        _mAV.setViewName("index-advanced");
        return _mAV;
    }

    @PostMapping("/repainted-advanced")
    public ModelAndView receiveFormAdvanced(MyParams params) {
        _mAV.addObject("params", params);
        _mAV.setViewName("index-advanced");
        return _mAV;
    }

}
