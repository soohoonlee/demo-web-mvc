package me.ssoon.demowebmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {

    @PostMapping("/events")
    @ResponseBody
    public Event getEvent(final @RequestParam String name, final @RequestParam Integer limit) {
        final Event event = new Event();
        event.setName(name);
        event.setLimit(limit);
        return event;
    }
}
