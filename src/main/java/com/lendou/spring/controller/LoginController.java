package com.lendou.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
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

    /**
     * The @RequestMapping annotation supports the use of regular expression in URI template variables. The syntax is
     * {varName:regex} where the first part defines the variable name and the second - the regular expression
     *
     * In addition to URI template, the @RequestMapping annotation also supports Ant-Style path pattern (e.g, /myPath/*.do).
     * A combination of URI template variable and Ant-style globs is also supported (e.g. /owners/"*"/pets/{petId} )
     */
    @RequestMapping(value = "/login/user/{userName:[a-z-]}")
    public String login(Model model, @PathVariable String userName) {
        System.out.println("in /login/user/{userName:[a-z-]}");

        return VIEW_HOME;
    }
}
