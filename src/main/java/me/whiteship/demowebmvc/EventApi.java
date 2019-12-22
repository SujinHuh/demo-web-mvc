package me.whiteship.demowebmvc;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/events")
public class EventApi {

    @GetMapping
    public Event createEvent(@RequestBody Event event) {
        //save
        return event;
    }
}
