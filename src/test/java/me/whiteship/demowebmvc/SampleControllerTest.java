package me.whiteship.demowebmvc;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@WebMvcTest
class SampleControllerTest {


    @Autowired
    MockMvc mockMvc;

    @Test
    public void hello() throws Exception {

        mockMvc.perform(get("/hello/Sujin"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("hello Sujin"))
                .andExpect(handler().handlerType(SampleController.class))
                .andExpect(handler().methodName("helloSujin"))
        ;
    }
}