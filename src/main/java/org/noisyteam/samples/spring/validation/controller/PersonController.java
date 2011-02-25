package org.noisyteam.samples.spring.validation.controller;

import javax.validation.Valid;
import org.noisyteam.samples.spring.validation.model.Person;
import org.noisyteam.samples.spring.validation.validator.PersonValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.validation.BindingResult;

/**
 * Handles requests for the application home page.
 *
 * @author Roman Romanchuk (fatroom@gmail.com)
 */
@Controller
public class PersonController {
    private static final String DEFAULT_VIEW = "WEB-INF/views/home.jsp";

    @InitBinder("person")
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(new PersonValidator());
    }

    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String home(Model model) {
        System.out.println("PersonController: Passing through...");
        model.addAttribute("person", new Person());
        return DEFAULT_VIEW;
    }

    @RequestMapping(value = "/", method=RequestMethod.POST)
    public String create(@Valid Person person, BindingResult result, Model model) {
        System.out.println("PersonController: Saving action");
        model.addAttribute("person", person);
        return DEFAULT_VIEW;
    }
}
