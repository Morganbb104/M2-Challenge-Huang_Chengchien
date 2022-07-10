package com.company.monthandmath.controller;


import com.company.monthandmath.models.Month;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomMonthController {
    private static List<Month> monthList= new ArrayList<>(Arrays.asList(
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
    @GetMapping("/randomMonth")
    @ResponseStatus(HttpStatus.OK)
    public Month getRandomMonthNumber(@PathVariable int number){
        int min = 1;
        int max = 12;
        int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);

        Month monthFound = null;
        for(Month month: monthList){
            if(random_int == number ){
                monthFound = month;
                break;
            }

        }
        return monthFound;

    }



}
