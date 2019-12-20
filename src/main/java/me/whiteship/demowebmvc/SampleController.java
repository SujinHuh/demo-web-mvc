package me.whiteship.demowebmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class SampleController {

    @GetMapping("/events/form")
    public String eventForm(Model model) {

        Event newEvent = new Event();
        newEvent.setLimit(30);
        model.addAttribute("event",newEvent);

        return "/events/form";
    }

    @PostMapping("/events")
    public String getEvent(@Validated @ModelAttribute Event event,
                           BindingResult bindingResult){

       if(bindingResult.hasErrors()){
           return "/events/form";
        }
        return "/events/list";
    }

}
