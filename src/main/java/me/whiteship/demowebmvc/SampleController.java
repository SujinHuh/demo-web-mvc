package me.whiteship.demowebmvc;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class SampleController {

    @RequestMapping(value = "/hello", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String hello() {
        return "hello" ;
    }

}
