package me.whiteship.demowebmvc;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest
public class SampleControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void postEvent() throws Exception {
        mockMvc.perform(post("/events")
                .param("name","Sujin")
                .param("limit", "-12"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().hasErrors())
        ;
    }

    @Test
    public void eventForm() throws Exception {
        ResultActions result = mockMvc.perform(get("/events/form"))
                .andDo(print())
                .andExpect(view().name("/events/form"))
                .andExpect(model().attributeExists("event"));
        ModelAndView modelAndView = result.andReturn().getModelAndView();
        Map<String, Object> model = modelAndView.getModel();
        System.out.println(model.size());

    }
}