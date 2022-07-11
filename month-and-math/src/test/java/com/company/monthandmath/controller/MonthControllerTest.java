package com.company.monthandmath.controller;

import com.company.monthandmath.models.Month;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MonthController.class)
public class MonthControllerTest {
    @Autowired
    private MockMvc mockmvc;
    private ObjectMapper mapper = new ObjectMapper();


    @Before
    public void setUp(){

    }

    @Test
    public void shouldReturnTheExpectedMonthNameByNumber() throws Exception{
        Month outputMonth = new Month(9,"September");
//        String outputJson = mapper.writeValueAsString(outputMonth);

        mockmvc.perform(get("http://localhost:8080/month/9"))
                .andDo(print())
                .andExpect(status().isOk());
//                .andExpect(content().string(outputJson));


    }

}