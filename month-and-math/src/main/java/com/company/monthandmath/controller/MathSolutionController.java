package com.company.monthandmath.controller;

import com.company.monthandmath.models.MathSolution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class MathSolutionController {
//add
@RequestMapping(value="/add",method= RequestMethod.GET)
@ResponseStatus(HttpStatus.OK)
    public MathSolution add(@Valid @RequestBody MathSolution mathSolution){

}


//@RequestMapping(value="/subtract",method= RequestMethod.GET)
//@ResponseStatus(HttpStatus.OK)

    //@RequestMapping(value="/multiply",method= RequestMethod.GET)
//@ResponseStatus(HttpStatus.OK)


    //@RequestMapping(value="/divide",method= RequestMethod.GET)
//@ResponseStatus(HttpStatus.OK)

}
