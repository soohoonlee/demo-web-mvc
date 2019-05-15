package me.ssoon.demowebmvc;

import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class EventApi {

    @PostMapping("/events")
    public ResponseEntity<Event> createEvent(final @RequestBody @Valid Event event,
        final BindingResult bindingResult) {
        // save event
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }
        return new ResponseEntity<>(event, HttpStatus.CREATED);
    }
}
