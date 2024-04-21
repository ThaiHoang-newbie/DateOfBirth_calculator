package com.example.demo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;

import controllers.DateOfBirthCalculator;
import controllers.FiveElementsCalculator;
import controllers.ZodiacCalculator;
import validations.InputValidator;

public class Person {
    private String name;
    private Date dateOfBirth;

    public Person(String name, Date dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    };

    public String getName() {
        return name;
    };

    private int getDayFromDate(Date dateOfBirth) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateOfBirth);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        return day;
    };

    private int getMonthFromDate(Date dateOfBirth) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateOfBirth);
        int day = calendar.get(Calendar.MONTH) + 1;
        return day;
    };

    private int getYearFromDate(Date dateOfBirth) {
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
        String ageCircle = calculateAge();
        String element = calculateElement();
        String zodiac = ZodiacCalculator();

        JSONObject infor = new JSONObject();
        infor.put("name", name);
        infor.put("date_of_birth", dateOfBirth);
        infor.put("age_circle", ageCircle);
        infor.put("element", element);
        infor.put("zodiac", zodiac);

        return infor;
    };

    public void saveUserInfoToFile(String filePath) {
        JSONObject userData = (JSONObject) saveUserInfo();

        JSONArray jsonArray;

        try {
            jsonArray = readExistingJsonArray(filePath);
        } catch (IOException e) {
            jsonArray = new JSONArray();
        }

        jsonArray.put(userData);

        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(jsonArray.toString(4));
            System.out.println("JSON data successfully written to file: " + filePath);
        } catch (IOException e) {
            System.out.println("An error occurred while writing JSON data to file: " + filePath);
            e.printStackTrace();
        };
    }

    private JSONArray readExistingJsonArray(String filePath) throws IOException {
        String jsonStr;

        try (FileReader fileReader = new FileReader(filePath)) {
            StringBuilder stringBuilder = new StringBuilder();
            int character;
            while ((character = fileReader.read()) != -1) {
                stringBuilder.append((char) character);
            }
            jsonStr = stringBuilder.toString();
        } catch (FileNotFoundException e) {
            return new JSONArray();
        } catch (IOException e) {
            throw e;
        }

        if (jsonStr.trim().isEmpty()) {
            return new JSONArray();
        } else {
            return new JSONArray(jsonStr);
        }
    }
}