package me.ssoon.demowebmvc;

import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EventApi {

    @PostMapping("/events")
    public Event createEvent(final @RequestBody @Valid Event event,
        final BindingResult bindingResult) {
        // save event
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(error -> System.out.println(error));
        }
        return event;
    }
}
