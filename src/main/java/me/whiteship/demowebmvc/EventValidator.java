package me.whiteship.demowebmvc;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class EventValidator {

    public void validate(Event event, Errors errors) {
        if(event.getName().equalsIgnoreCase("aaa")) {
            errors.rejectValue("name","worgValue","the valus is not allow");

        }
    }
}
