package me.ssoon.demowebmvc;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String createEvent(final @Validated @ModelAttribute Event event,
        final BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/events/form";
        }
        return "redirect:/events/list";
    }

    @GetMapping("/events/list")
    public String getEvents(final Model model) {
        final Event event = new Event();
        event.setName("spring");
        event.setLimit(10);

        final List<Event> eventList = new ArrayList<>();
        eventList.add(event);

        model.addAttribute("eventList", eventList);
        return "/events/list";
    }
}
