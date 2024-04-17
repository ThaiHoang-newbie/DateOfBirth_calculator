package com.example.demo;
import java.util.Calendar;
import java.util.Date;

import controllers.DateOfBirthCalculator;
import controllers.FiveElementsCalculator;
import controllers.ZodiacCalculator;
import validations.InputValidator;

public class Person {
    private String name;
    private Date dateOfBirth;
    
    public Person(String name, Date dateOfBirth){
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    };

    public String getName() {
        return name;
    };


    private int getDayFromDate(Date dateOfBirth){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateOfBirth);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        return day;
    };
    private int getMonthFromDate(Date dateOfBirth){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateOfBirth);
        int day = calendar.get(Calendar.MONTH) + 1;
        return day;
    };
    private int getYearFromDate(Date dateOfBirth){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateOfBirth);
        int day = calendar.get(Calendar.YEAR);
        return day;
    };

    public boolean isValidDateOfBirth() {
        int day = getDayFromDate(dateOfBirth);
        int month = getMonthFromDate(dateOfBirth);
        int year = getYearFromDate(dateOfBirth);
        return InputValidator.isValidDay(day, month, year);
    };

    public String calculateAge() {
        int year = getYearFromDate(dateOfBirth);
        DateOfBirthCalculator dobCalculator = new DateOfBirthCalculator();
        return dobCalculator.calculateDateOfBirth(year);
    };

    public String calculateElement() {
        int year = getYearFromDate(dateOfBirth);
        FiveElementsCalculator elementsCalculator = new FiveElementsCalculator();
        return elementsCalculator.calculateFiveElements(year);
    };

    public String ZodiacCalculator() {
        int day = getDayFromDate(dateOfBirth);
        int month = getMonthFromDate(dateOfBirth);
        ZodiacCalculator zodiacCalculator = new ZodiacCalculator();
        return zodiacCalculator.calculateZodiacSign(day, month);
    };

    public Object saveUserInfo() {
        String name = getName();
        String age_circle = calculateAge();
        String element = calculateElement();
        String zodiac = ZodiacCalculator();

        Object[] infor = {
            "name", name,
            "age_circle", age_circle,
            "element", element,
            "zodiac", zodiac
        };
        
        System.out.println(infor[0]);
        return infor;
    };
}