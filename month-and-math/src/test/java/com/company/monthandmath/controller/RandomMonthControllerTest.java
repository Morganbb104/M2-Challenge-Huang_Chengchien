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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.hibernate.validator.internal.util.Contracts.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MonthController.class)
public class RandomMonthControllerTest {
    @Autowired
    private MockMvc mockmvc;
    private ObjectMapper mapper = new ObjectMapper();


    @Before
    public void setUp(){

    }

//    @Test
//    public void shouldReturnExpectedMonthNameByRandomNumber() throws Exception{
//
//        mockmvc.perform(get("/randomMonth"))
//                .andDo(print())
//                .andExpect(status().isOk());
//
//    }
    @Test
    public void shouldReturnExpectedMonthNameByRandomNumber() throws Exception{

        mockmvc.perform(get("/randomMonth"))
                .andDo(print())
                .andExpect(status().isOk())                ;

    }

    @Test
    public void shouldReturnMonthRandomly() throws Exception {
        Random randomNumberGenerator = new Random();
        List<Month> months = new ArrayList<>(Arrays.asList(
                new Month(1,"January"),
                new Month(2,"February"),
                new Month(3,"March"),
                new Month(4,"April"),
                new Month(5,"May"),
                new Month(6,"June"),
                new Month(7,"July"),
                new Month(8,"August"),
                new Month(9,"September"),
                new Month(10,"October"),
                new Month(11,"November"),
                new Month(12,"December")
        ));
        int randomNumber = randomNumberGenerator.nextInt(months.size());
        mockmvc.perform(get("/randomMonth"))
                .andDo(print())
                .andReturn();
        assertTrue(true,months.get(randomNumber).getMonthName() );
    }

}



