package me.ssoon.demowebmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping("/events/name/{name}")
    @ResponseBody
    public Event getEvent(final @Validated(Event.ValidateName.class) @ModelAttribute Event event, final BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println("==================================");
            bindingResult.getAllErrors().forEach(c -> System.out.println(c.toString()));
        }
        return event;
    }
}
