package me.whiteship.demowebmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    @ResponseBody
    public Event getEvent(@ModelAttribute Event event){

        return event;
    }

}
