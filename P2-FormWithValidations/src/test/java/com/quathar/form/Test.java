package com.quathar.form;

import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Test {

    public static void main(String[] args) {
        try {
            String date = "03/04/2002";
            System.out.println(Period.between(LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalDate.now()).getYears());
        } catch (DateTimeParseException e) {
            System.err.println("error en parseo");
        }
    }

}
