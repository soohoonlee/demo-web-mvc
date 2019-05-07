package me.ssoon.demowebmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {

    @GetMapping("/events/form")
    public String eventsForm(final Model model) {
        final Event newEvent = new Event();
        newEvent.setLimit(50);
        model.addAttribute("event", newEvent);
        return "/events/form";
    }

    @PostMapping("/events")
    @ResponseBody
    public Event getEvent(final @RequestParam String name, final @RequestParam Integer limit) {
        final Event event = new Event();
        event.setName(name);
        event.setLimit(limit);
        return event;
    }
}
