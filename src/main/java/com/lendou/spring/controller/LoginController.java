package com.lendou.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
    private static final String VIEW_INDEX = "login";
    private static final String VIEW_HOME = "home";
    private final static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String redirectToLogin(ModelMap model) {
        System.out.println("in redirectToLogin method");
        logger.debug("in redirectToLogin method");

        // Spring uses InternalResourceViewResolver and return back index.jsp
        return VIEW_INDEX;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(ModelMap model) {
        System.out.println("in login method");
        logger.debug("in login method");

        String userName = (String) model.get("username");
        String password = (String) model.get("password");

        System.out.println("====================== lendou ========================");

        System.out.println("username: " + userName);
        System.out.println("password: " + password);

        // Spring uses InternalResourceViewResolver and return back index.jsp
        return VIEW_HOME;
    }
}
