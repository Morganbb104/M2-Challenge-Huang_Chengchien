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

    //successful Test in add
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
    // missing operand in add
    @Test
    public void shouldReturnError422OfSumTwoNumbersInMissingOperand() throws Exception{
        MathSolution mathSolution = new MathSolution();
        mathSolution.setOperand1(6);

        String inputString = mapper.writeValueAsString(mathSolution);

        this.mockmvc.perform(post("/add")
                        .content(inputString)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }



    // successful test in subtract
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

    // missing operand in subtract
    @Test
    public void shouldReturnError422OfDifferenceTwoNumbersInMissingOperand() throws Exception{
        MathSolution mathSolution = new MathSolution();
        mathSolution.setOperand1(6);

        String inputString = mapper.writeValueAsString(mathSolution);

        this.mockmvc.perform(post("/subtract")
                        .content(inputString)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    // successful test in multiply
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

    // missing operand in multiply
    @Test
    public void shouldReturnError422OfProductTwoNumbersInMissingOperand() throws Exception{
        MathSolution mathSolution = new MathSolution();
        mathSolution.setOperand1(6);

        String inputString = mapper.writeValueAsString(mathSolution);

        this.mockmvc.perform(post("/multiply")
                        .content(inputString)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    // successful Test in divide
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

    // missing operand in Divide
    @Test
    public void shouldReturnError422OfQuotientTwoNumbersInMissingOperand() throws Exception{
        MathSolution mathSolution = new MathSolution();
        mathSolution.setOperand1(6);

        String inputString = mapper.writeValueAsString(mathSolution);

        this.mockmvc.perform(post("/divide")
                        .content(inputString)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }



    // Divided by zero and return status 422
    @Test
    public void shouldReturnStatus422IfOperand2IsZero() throws Exception{
        MathSolution mathSolution = new MathSolution();
        mathSolution.setOperand1(6);
        mathSolution.setOperand2(0);
        String inputString = mapper.writeValueAsString(mathSolution);

        this.mockmvc.perform(post("/divide")
                        .content(inputString)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());


    }

}