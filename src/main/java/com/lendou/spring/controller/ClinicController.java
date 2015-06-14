package com.lendou.spring.controller;

import com.lendou.spring.form.Clinic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Methods in this controller does not specify GET vs. PUT POST, and so forth, because @RequestMapping maps all HTTP methods
 * by default. Use @RequeestMapping(method = GET) to narrow the mapping.
 */
@Controller
public class ClinicController {
    private final Clinic clinic;

    @Autowired
    public ClinicController(Clinic clinic) {
        this.clinic = clinic;
    }

    @RequestMapping("/")
    public void welcomeHandler() {
    }

    @RequestMapping("/vets")
    public ModelMap vetsHandler() {
        return new ModelMap(this.clinic.getVets());
    }
}
