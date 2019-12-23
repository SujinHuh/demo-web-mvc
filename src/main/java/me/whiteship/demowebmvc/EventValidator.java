package me.whiteship.demowebmvc;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class EventValidator implements Validator {


    @Override
    public boolean supports(Class<?> aClass) {
        return Event.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Event event = (Event)target;
        if(event.getName().equalsIgnoreCase("aaa")) {
            errors.rejectValue("name","worgValue","the valus is not allow");

        }
    }
}
