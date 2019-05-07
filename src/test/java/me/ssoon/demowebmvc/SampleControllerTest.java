package me.ssoon.demowebmvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest
public class SampleControllerTest {
    
    @Autowired
    MockMvc mockMvc;

    @Test
    public void eventForm() throws Exception {
        mockMvc.perform(get("/events/form"))
            .andDo(print())
            .andExpect(view().name("/events/form"))
            .andExpect(model().attributeExists("event"));
    }

    @Test
    public void postEvent() throws Exception {
        mockMvc.perform(post("/events/name/soohoon")
                .param("limit", "-10"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("name").value("soohoon"));
    }
}