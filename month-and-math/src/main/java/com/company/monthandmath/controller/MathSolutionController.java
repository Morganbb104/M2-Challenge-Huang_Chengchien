package com.company.monthandmath.controller;

import com.company.monthandmath.models.MathSolution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
public class MathSolutionController {
    //add
    @PostMapping(value = "/add")
    @ResponseStatus(value = HttpStatus.OK)
    public MathSolution add(@Valid @RequestBody MathSolution input) {
        if ((input.getOperand1() == 0 || input.getOperand2() == 0)) {
            throw new IllegalArgumentException("you have to provide an integer for both operands");
        }
        return new MathSolution(input.getOperand1(), input.getOperand2(), "add", input.getOperand1() + input.getOperand2());
    }

    @PostMapping(value = "/subtract")
    @ResponseStatus(value = HttpStatus.OK)
    public MathSolution subtract(@Valid @RequestBody MathSolution input) {
        if ((input.getOperand1() == 0 || input.getOperand2() == 0)) {
            throw new IllegalArgumentException("you have to provide an integer for both operands");
        }
        return new MathSolution(input.getOperand1(), input.getOperand2(), "subtract", input.getOperand1() - input.getOperand2());
    }

    @PostMapping(value = "/multiply")
    @ResponseStatus(value = HttpStatus.OK)
    public MathSolution multiply(@Valid @RequestBody MathSolution input) {
        if ((input.getOperand1() == 0 || input.getOperand2() == 0)) {
            throw new IllegalArgumentException("you have to provide an integer for both operands");
        }
        return new MathSolution(input.getOperand1(), input.getOperand2(), "multiply", input.getOperand1() * input.getOperand2());
    }

    @PostMapping(value = "/divide")
    @ResponseStatus(value = HttpStatus.OK)
    public MathSolution divide(@Valid @RequestBody MathSolution input) {
        if ((input.getOperand1() == 0 || input.getOperand2() == 0)) {
            throw new IllegalArgumentException("you have to provide an integer for both operands");
        }
        return new MathSolution(input.getOperand1(), input.getOperand2(), "divide", input.getOperand1() / input.getOperand2());
    }

}
