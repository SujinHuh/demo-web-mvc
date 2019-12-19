package me.whiteship.demowebmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@Controller
public class SampleController {

    @PostMapping("/events")
    @ResponseBody
    public Event getEvent(@RequestParam Map<String,String> params){

        Event event = new Event();
        event.setName(params.get("name"));
        return event;
    }

}
