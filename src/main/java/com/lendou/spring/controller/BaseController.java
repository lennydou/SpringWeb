package com.lendou.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * A Controller's responsibility:
 *   1. Preparing a model 'Map' with data
 *   2. Selecting a view name
 *
 * While Controller can also write directly to the response stream and complete the request.
 *
 * Spring does not require you to extend any controller base class or reference the Servlet API. However, you can still
 * reference Servlet-specific features if you need do.
 */
@Controller
public class BaseController {
    private static int counter = 0;
    private static final String VIEW_INDEX = "index";
    private final static Logger logger = LoggerFactory.getLogger(BaseController.class);

    /**
     * The model (the M in MVC) is a 'Map' interface, which allows for the complete abstraction of view technology.
     *
     * You can integrate directly with template based rendering technologies such as JSP, Velocity and Freemarker, or
     * directly generate XML, JSON, Atom, and many other types of content.
     *
     * The model 'Map' is simply transformed into an appropriate format, such as JSP request attributes, a Velocity template model.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome(Model model) {
        System.out.println("in welcome method");
        logger.debug("[welcome] counter: {}", counter);

        // Spring uses InternalResourceViewResolver and return back index.jsp
        return VIEW_INDEX;
    }



//    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
//    public String welcomeName(@PathVariable String name, ModelMap model) {
//        model.addAttribute("message", "Welcome " + name);
//        model.addAttribute("counter", ++counter);
//
//        System.out.println("in welcomeName method");
//        logger.debug("[welcomeName] counter: {}", counter);
//
//        return VIEW_INDEX;
//    }
}
