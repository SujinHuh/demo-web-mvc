package me.whiteship.demowebmvc;

import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/events")
public class EventApi {

    @GetMapping
    public Event createEvent(HttpEntity<Event> requst) {
        //save

        MediaType contentType = requst.getHeaders().getContentType();
        System.out.println(contentType);
       return requst.getBody();
    }
}
