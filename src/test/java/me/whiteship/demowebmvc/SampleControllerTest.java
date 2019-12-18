package me.whiteship.demowebmvc;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.hasItems;
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

        mockMvc.perform(options("/hello"))
                .andDo(print())
                .andExpect(status().isOk())
                //응답 헤더 확인
                .andExpect(header().stringValues(HttpHeaders.ALLOW,
                                                 hasItems(
                                                         containsString("GET"),
                                                         containsString("OPTIONS"),
                                                         containsString("POST"),
                                                         containsString("HEAD")
                                                        )))

        ;
    }
}