package me.ssoon.demowebmvc;

import java.util.List;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice(assignableTypes = {EventController.class, EventApi.class})
public class BaseController {

    @ExceptionHandler({EventException.class, RuntimeException.class})
    public String eventErrorHandler(final RuntimeException exception, final Model model) {
        model.addAttribute("message", "runtime error");
        return "error";
    }

    @InitBinder
    public void initEventBinder(final WebDataBinder webDataBinder) {
        webDataBinder.setDisallowedFields("id");
        webDataBinder.addValidators(new EventValidator());
    }

    @ModelAttribute
    public void categories(final Model model) {
        model.addAttribute("categories", List.of("study", "seminar", "hobby", "social"));
    }
}
