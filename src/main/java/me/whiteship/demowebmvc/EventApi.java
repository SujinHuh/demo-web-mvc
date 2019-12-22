package me.whiteship.demowebmvc;

import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/events")
public class EventApi {

    @PostMapping
    public Event createEvent(@Valid @RequestBody Event event, BindingResult bindingResult) {
        //save

        if(bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(error ->{
                System.out.println(error);
            });

        }
        return event;
    }
}
