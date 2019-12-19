package me.whiteship.demowebmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class SampleController {

    @PostMapping("/events")
    @ResponseBody
    public Event getEvent(@RequestParam String name){

        Event event = new Event();
        event.setName(name);
        return event;
    }

}
