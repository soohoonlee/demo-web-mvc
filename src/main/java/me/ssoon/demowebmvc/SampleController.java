package me.ssoon.demowebmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
public class SampleController {

    @GetMapping("/soohoon")
    @ResponseBody
    public String helloSoohoon() {
        return "hello soohoon";
    }

}
