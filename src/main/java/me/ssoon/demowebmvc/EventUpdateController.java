package me.ssoon.demowebmvc;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
    consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class EventUpdateController {

    @PostMapping("/events")
    @ResponseBody
    public String createEvent() throws Exception {
        return "events";
    }

    @PutMapping( "/events")
    @ResponseBody
    public String updateEvent() throws Exception {
        return "events";
    }
}
