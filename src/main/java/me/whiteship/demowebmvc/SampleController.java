package me.whiteship.demowebmvc;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class SampleController {

    @GetMapping("/hello")
    @ResponseBody
    public String helloGet() {
        return "hello" ;
    }

    @PostMapping("/hello")
    @ResponseBody
    public String helloPost() {
        return "hello" ;
    }

}
