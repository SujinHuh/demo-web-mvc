package me.whiteship.demowebmvc;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/api/events")
public class EventApi {

    @ExceptionHandler
    public ResponseEntity errorHandler() {
        return ResponseEntity.badRequest().body("Can't CreateEvent as...");
    }

    @PostMapping
    public ResponseEntity<Event> createEvent(@Valid @RequestBody Event event, BindingResult bindingResult) {
        //save

        if(bindingResult.hasErrors()) {
           ResponseEntity.badRequest();
           return ResponseEntity.badRequest().build();
        }
        return new ResponseEntity<Event>(event, HttpStatus.CREATED);
    }
}
