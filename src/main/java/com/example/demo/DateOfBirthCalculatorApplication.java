package com.example.demo;
import org.json.simple.parser.ParseException;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import controllers.JSONSearch;
import validations.InputValidator;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class DateOfBirthCalculatorApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String personName = scanner.nextLine();
        System.out.print("Enter the date (dd-mm-yyyy): ");
        String dateString = scanner.next();
        scanner.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse(dateString, formatter);
        int day = date.getDayOfMonth();
        int month = date.getMonthValue();
        int year = date.getYear();

        Person person = new Person(personName, java.sql.Date.valueOf(date));
        String filePath = "data.json";

        if (!InputValidator.isValidDay(day, month, year)) {
            System.out.println("Invalid date of birth, please check again");
        } else {
            person.saveUserInfo();
            person.saveUserInfoToFile("data.json");
            System.out.println(person.getName() + " has " + person.calculateAge() + " age, " + person.calculateElement()
                    + " element, "
                    + "and " + person.ZodiacCalculator() + " zodiac ");
        }

        // search usage
        System.out.print("Enter your name that you wanna search: ");
        String nameSearch = scanner.nextLine();

        try {
            JSONSearch jsonSearch = new JSONSearch(filePath);
            List<String> searchResults = jsonSearch.searchByName(nameSearch);
            if (searchResults.size() != 0) {
                for (String result : searchResults) {
                    System.out.println(result);
                }
            } else {
                System.out.println("Data not found");
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

}
