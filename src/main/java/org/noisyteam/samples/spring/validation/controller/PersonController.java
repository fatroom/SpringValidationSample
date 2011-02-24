package org.noisyteam.samples.spring.validation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 *
 * @author Roman Romanchuk (fatroom@gmail.com)
 */
@Controller
public class PersonController {
    private static final String DEFAULT_VIEW = "WEB-INF/views/home.jsp";

    @RequestMapping(value = "/")
    public String home() {
        System.out.println("PersonController: Passing through...");
        return DEFAULT_VIEW;
    }

    @RequestMapping(value = "/", method=RequestMethod.PUT)
    public String create() {
        System.out.println("PersonController: Saving action");
        return DEFAULT_VIEW;
    }
}
