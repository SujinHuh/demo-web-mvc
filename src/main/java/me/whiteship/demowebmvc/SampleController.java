package me.whiteship.demowebmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hello")
public class SampleController {

    @RequestMapping("/{name:[a-z]+}")
    @ResponseBody
    public String hello(@PathVariable String name) {
        return "hello" + name;
    }
}
