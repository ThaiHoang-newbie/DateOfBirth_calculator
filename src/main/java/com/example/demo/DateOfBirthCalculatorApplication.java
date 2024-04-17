package com.example.demo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import validations.InputValidator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

@SpringBootApplication
public class DateOfBirthCalculatorApplication {

	public static void main(String[] args) {
		// SpringApplication.run(DateOfBirthCalculatorApplication.class, args);
		Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String personName = scanner.nextLine();
        System.out.print("Enter the date (dd-mm-yyyy): ");
        String dateString = scanner.next();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse(dateString, formatter);
        int day = date.getDayOfMonth();
        int month = date.getMonthValue();
        int year = date.getYear();

        Person person = new Person(personName, java.sql.Date.valueOf(date));

        if (!InputValidator.isValidDay(day, month, year) ) {
            System.out.println("Invalid date of birth, please check again");
        } else {
            person.saveUserInfo();
            System.out.println(person.getName() + " has " + person.calculateAge() + " age, " + person.calculateElement() + " element, "
                    + "and " + person.ZodiacCalculator() + " zodiac ");
        }
	}

}
