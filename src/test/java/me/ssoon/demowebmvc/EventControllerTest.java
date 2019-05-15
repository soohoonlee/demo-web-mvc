package me.ssoon.demowebmvc;

import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;

import java.time.LocalDateTime;
import java.util.Map;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.servlet.ModelAndView;

@RunWith(SpringRunner.class)
@WebMvcTest
public class EventControllerTest {
    
    @Autowired
    MockMvc mockMvc;

    @Test
    public void eventForm() throws Exception {
        mockMvc.perform(get("/events/form"))
            .andDo(print())
            .andExpect(view().name("/events/form"))
            .andExpect(model().attributeExists("event"))
            .andExpect(request().sessionAttribute("event", notNullValue()));
    }

    @Test
    public void postEvent() throws Exception {
        final ResultActions result = mockMvc.perform(post("/events")
            .param("name", "soohoon")
            .param("limit", "-10"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(model().hasErrors());
        final ModelAndView modelAndView = result.andReturn().getModelAndView();
        final Map<String, Object> model = modelAndView.getModel();
        System.out.println(model.size());
    }

    @Test
    public void getEvents() throws Exception {
        final Event newEvent = new Event();
        newEvent.setName("Winter is coming.");
        newEvent.setLimit(10000);

        mockMvc.perform(get("/events/list")
            .sessionAttr("visitTime", LocalDateTime.now())
            .flashAttr("newEvent", newEvent))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(xpath("//p").nodeCount(2));
    }
}