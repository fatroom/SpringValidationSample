package org.noisyteam.samples.spring.validation.controller;

import org.noisyteam.samples.spring.validation.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String home(Model model) {
        System.out.println("PersonController: Passing through...");
        model.addAttribute("person", new Person());
        return DEFAULT_VIEW;
    }

    @RequestMapping(value = "/", method=RequestMethod.PUT)
    public String create() {
        System.out.println("PersonController: Saving action");
        return DEFAULT_VIEW;
    }
}
