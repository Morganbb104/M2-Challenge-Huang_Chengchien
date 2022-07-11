package com.company.monthandmath.controller;

import com.company.monthandmath.models.MathSolution;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(MathSolutionController.class)
public class MathSolutionControllerTest {
    @Autowired
    private MockMvc mockmvc;
    private ObjectMapper mapper = new ObjectMapper();


    @Before
    public void setUp() throws Exception{

    }

    @Test
    public void shouldReturnSumOfTwoNumbers() throws Exception{
        MathSolution mathSolution = new MathSolution();
        mathSolution.setOperand1(6);
        mathSolution.setOperand2(3);
        String inputString = mapper.writeValueAsString(mathSolution);

        MathSolution output = new MathSolution(6,3,"add",9);
        String outputString = mapper.writeValueAsString(output);

        this.mockmvc.perform(post("/add")
                .content(inputString)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputString));
    }

    @Test
    public void shouldReturnDifferenceOfTwoNumbers() throws Exception{
        MathSolution mathSolution = new MathSolution();
        mathSolution.setOperand1(6);
        mathSolution.setOperand2(3);
        String inputString = mapper.writeValueAsString(mathSolution);

        MathSolution output = new MathSolution(6,3,"subtract",3);
        String outputString = mapper.writeValueAsString(output);

        this.mockmvc.perform(post("/subtract")
                        .content(inputString)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputString));


    }

    @Test
    public void shouldReturnProductOfTwoNumbers() throws Exception{
        MathSolution mathSolution = new MathSolution();
        mathSolution.setOperand1(6);
        mathSolution.setOperand2(3);
        String inputString = mapper.writeValueAsString(mathSolution);

        MathSolution output = new MathSolution(6,3,"multiply",18);
        String outputString = mapper.writeValueAsString(output);

        this.mockmvc.perform(post("/multiply")
                        .content(inputString)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputString));


    }
    @Test
    public void shouldReturnQuotientOfTwoNumbers() throws Exception{
        MathSolution mathSolution = new MathSolution();
        mathSolution.setOperand1(6);
        mathSolution.setOperand2(3);
        String inputString = mapper.writeValueAsString(mathSolution);

        MathSolution output = new MathSolution(6,3,"divide",2);
        String outputString = mapper.writeValueAsString(output);

        this.mockmvc.perform(post("/divide")
                        .content(inputString)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputString));


    }

}