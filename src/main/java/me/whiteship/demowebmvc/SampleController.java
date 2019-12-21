package me.whiteship.demowebmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@SessionAttributes("event")
public class SampleController {

    @GetMapping("/events/form/name")
    public String eventFormName(Model model) {

        model.addAttribute("event", new Event());
        return "/events/form-name";
    }

    @PostMapping("/events/form/name")
    public String evnetsFormNameSubmit(@Validated @ModelAttribute Event event,
                                  BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "/events/form-name";
        }

        return "redirect:/events/form/limit";
    }

    @GetMapping("/events/form/limit")
    public String eventFormLime(@ModelAttribute Event event, Model model) {

        model.addAttribute("event", event);
        return "/events/form-limit";
    }

    @PostMapping("/events/form/limit")
    public String evnetsFormLimeSubmit(@Validated @ModelAttribute Event event,
                                       BindingResult bindingResult,
                                       SessionStatus sessionStatus,
                                       RedirectAttributes attributes) {

        if (bindingResult.hasErrors()) {
            return "/events/form-limit";
        }

        attributes.addAttribute("name",event.getName());
        attributes.addAttribute("limie",event.getLimit());
        sessionStatus.setComplete();
        return "redirect:/events/list";
    }


    @GetMapping("/events/list")
    public String getEvent(Model model ,@SessionAttribute LocalDateTime visitTime) {

        System.out.println(visitTime);
        Event newEvent = new Event();
        newEvent.setName("Sujin");
        newEvent.setLimit(10);


        List<Event> eventList = new ArrayList<>();
        eventList.add(newEvent);
        model.addAttribute("eventList", eventList);
        return "/events/list";
    }
}
