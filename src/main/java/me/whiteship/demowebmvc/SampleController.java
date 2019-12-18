package me.whiteship.demowebmvc;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class SampleController {

    @RequestMapping(value = "/hello",params = "name=Sujin")
    @ResponseBody
    public String hello() {
        return "hello" ;
    }

}
