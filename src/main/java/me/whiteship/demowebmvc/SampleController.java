package me.whiteship.demowebmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@SessionAttributes("event")
public class SampleController {

    @GetMapping("/events/form")
    public String eventForm(Model model) {

        Event newEvent = new Event();
        newEvent.setLimit(30);
        model.addAttribute("event",newEvent);
        return "/events/form";
    }

    @PostMapping("/events")
    public String createEvent(@Validated @ModelAttribute Event event,
                           BindingResult bindingResult,
                            SessionStatus sessionStatus){

       if(bindingResult.hasErrors()){
           return "/events/form";
        }
    //save
//       List<Event> eventList = new ArrayList<>();
//       eventList.add(event);
//       model.addAttribute("eventList",eventList);

        sessionStatus.setComplete();
        return "redirect:/events/list";
    }

    @GetMapping("/events/list")
    public String getEvent(Model model) {

        Event newEvent = new Event();
        newEvent.setName("Sujin");
        newEvent.setLimit(10);


        List<Event> eventList = new ArrayList<>();
        eventList.add(newEvent);
        model.addAttribute("eventList", eventList);
        return "/events/list";
    }
}
