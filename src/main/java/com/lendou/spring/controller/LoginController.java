package com.lendou.spring.controller;

import org.omg.CORBA.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * You use the @RequestMapping annotation to map URLs such as '/appointments' onto an entire class or a particular handler
 * method. Typically the class-level annotation maps a specific request path (or path pattern) onto a form controller,
 * with additional method-level annotations narrowing the primary mapping for a specific HTTP method request method ('GET', 'POST', etc)
 * or an HTTP request parameter condition.
 */
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

    /**
     Path Pattern
     * In addition to URI templates, the @RequestMapping annotation also supports Ant-style path patterns (for example, /myPath/*.do).
     * A combination of URI template variables and Ant-style globs is also supported (e.g. /owners/'*'/pets/{petId})
     *
     * When a URL matches multiple patterns, a sort is used to find the most specific match.
     * When two patterns have the same count and length, the pattern with fewer wild cards is considered more specific. For example,
     * /hotels/{hotel} is more specific that /hotels/*
     *
     * Path Pattern Matching By Suffix
     * By default Spring MVC automatically performs ".*" suffix pattern matching so that a controller mapped to /person is also implicitly mapped to /person.*
     * This allows indicating content types via file extensions, e.g. /person.pdf, /person.xml, etc.
     *
     * A common pitfall is last segment of the mapping is a URI variable, e.g. /person/{id}. While a request for /person/1.json would
     * result in path variable id=1 and extension ".json"
     */
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
     * The proposed RFC for URI templates defines how a URI is parameterized. In Sring MVC you can use the @PathVariable
     * annotation on a method argument to bind it to the value of a URI template variable:
     *
     * If {userName} is same as String userName, you can omit parameter of @PathVariable
     *
     * The @RequestMapping annotation supports the use of regular expressions in URI template variables. The syntax is
     * {varName:regex} where the first part defines the variable name and the second - the regular expression.
     */
    @RequestMapping(value = "/login/{userName}", method = RequestMethod.POST)
    public String userLogin(@PathVariable("userName") String userName, Model model) {
        return VIEW_HOME;
    }
}
