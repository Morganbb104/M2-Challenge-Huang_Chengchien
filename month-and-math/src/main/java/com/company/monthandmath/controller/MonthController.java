package com.company.monthandmath.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MonthController {
    @RequestMapping(value="/month",method= RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
}
