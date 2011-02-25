package org.noisyteam.samples.spring.validation.validator;

import org.junit.Before;
import org.junit.Test;
import org.noisyteam.samples.spring.validation.model.Person;
import org.noisyteam.samples.spring.validation.validator.PersonValidator;
import org.springframework.validation.DataBinder;
import org.springframework.validation.BindingResult;

import static org.junit.Assert.*;

public class PersonValidatorTest {
    private BindingResult bindingResult;
    private PersonValidator validator;
    private Person person;

    @Before
    public void initialize() {
        validator = new PersonValidator();
        person = new Person();
        bindingResult = new DataBinder(person).getBindingResult();
    }


    @Test
    public void validatePersonWithEmptyName() {
        person.setNickname("Nickname");
        validator.validate(person, bindingResult);
        assertFalse("There are some global errors during validation", bindingResult.hasGlobalErrors());
        assertTrue("There aren't field errors during validation", bindingResult.hasFieldErrors());
        assertEquals("Unexpected field errors count", 1, bindingResult.getFieldErrorCount());
        assertNull("Error for 'nickname' field found", bindingResult.getFieldError("nickname"));
        assertNotNull("Error for 'name' field not found", bindingResult.getFieldError("name"));
    }

    @Test
    public void validatePersonWithEmptyNickname() {
        person.setName("Name");
        validator.validate(person, bindingResult);
        assertFalse("There are some global errors during validation", bindingResult.hasGlobalErrors());
        assertTrue("There aren't field errors during validation", bindingResult.hasFieldErrors());
        assertEquals("Unexpected field errors count", 1, bindingResult.getFieldErrorCount());
        assertNull("Error for 'name' field found", bindingResult.getFieldError("name"));
        assertNotNull("Error for 'nickname' field not found", bindingResult.getFieldError("nickname"));
    }

    @Test
    public void validateEmptyPerson() {
        validator.validate(person, bindingResult);
        assertFalse("There are some global errors during validation", bindingResult.hasGlobalErrors());
        assertTrue("There aren't field errors during validation", bindingResult.hasFieldErrors());
        assertEquals("Unexpected field errors count", 2, bindingResult.getFieldErrorCount());
        assertNotNull("Error for 'name' field not found", bindingResult.getFieldError("name"));
        assertNotNull("Error for 'nickname' field not found", bindingResult.getFieldError("nickname"));
    }

    @Test
    public void validateFilledPerson() {
        person.setName("Name");
        person.setNickname("Nickname");
        validator.validate(person, bindingResult);
        assertFalse("There are some global errors during validation", bindingResult.hasGlobalErrors());
        assertFalse("There are some field errors during validation", bindingResult.hasFieldErrors());
    }

}
