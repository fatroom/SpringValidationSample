package org.noisyteam.samples.spring.validation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handles requests for the application home page.
 *
 * @author Roman Romanchuk (fatroom@gmail.com)
 */
@Controller
public class PersonController {

    @RequestMapping(value = "/")
    public String home() {
        System.out.println("HomeController: Passing through...");
        return "WEB-INF/views/home.jsp";
    }
}
