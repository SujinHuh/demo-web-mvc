package me.whiteship.demowebmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hello")
public class SampleController {

    @RequestMapping("/Sujin")
    @ResponseBody
    public String helloSujin() {
        return "hello Sujin" ;
    }

    @RequestMapping("/**")
    @ResponseBody
    public String hello() {
        return "hello" ;
    }
}
