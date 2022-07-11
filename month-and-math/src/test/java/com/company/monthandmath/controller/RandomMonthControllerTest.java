package com.company.monthandmath.controller;

import com.company.monthandmath.models.Month;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class RandomMonthControllerTest {
    @Autowired
    private MockMvc mockmvc;
    private ObjectMapper mapper = new ObjectMapper();


    @Before
    public void setUp(){

    }

    @Test
    public void shouldReturnExpectedMonthNameByRandomNumber() throws Exception{
        Month outputMonth = new Month(9,"September");
//        String outputJson = mapper.writeValueAsString(outputMonth);

        mockmvc.perform(get("http://localhost:8080/randomMonth"))
                .andDo(print())
                .andExpect(status().isOk());
                .andExpect(content().string(outputJson));


    }

}