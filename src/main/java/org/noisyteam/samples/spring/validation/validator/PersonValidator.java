package org.noisyteam.samples.spring.validation.validator;

import org.noisyteam.samples.spring.validation.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Class for validation of binded Person objects.
 * 
 * @author Roman Romanchuk (fatroom@gmail.com)
 */
public class PersonValidator implements Validator {
    private static final Logger logger = LoggerFactory.getLogger(PersonValidator.class);
    /**
     * This Validator validates just Person instances
     */
    public boolean supports(Class<?> clazz) {
	    return Person.class.equals(clazz);
    }

    public void validate(Object obj, Errors e) {
        logger.trace("Validating person object");
	    ValidationUtils.rejectIfEmpty(e, "name", "name.empty", "Can't be empty");
	    ValidationUtils.rejectIfEmpty(e, "nickname", "nickname.empty","Can't be empty");
    }

}
