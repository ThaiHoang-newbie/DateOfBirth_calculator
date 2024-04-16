import java.util.Calendar;
import java.util.Date;

import controllers.DateOfBirthCalculator;
import controllers.FiveElementsCalculator;
import controllers.ZodiacCalculator;
import validations.InputValidator;

public class Person {
    private String name;
    private Date dateOfBirth;
    
    public Person(String name, int dayOfBirth, int monthOfBirth, int yearOfBirth){
        this.name = name;
    }

    public String getName() {
        return name;
    }


    private int getDayFromDate(Date dateOfBirth){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateOfBirth);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        return day;
    }
    private int getMonthFromDate(Date dateOfBirth){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateOfBirth);
        int day = calendar.get(Calendar.MONTH) + 1;
        return day;
    }
    private int getYearFromDate(Date dateOfBirth){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateOfBirth);
        int day = calendar.get(Calendar.YEAR);
        return day;
    }

    public boolean isValidDateOfBirth() {
        int day = getDayFromDate(dateOfBirth);
        int month = getMonthFromDate(dateOfBirth);
        int year = getYearFromDate(dateOfBirth);
        return InputValidator.isValidDay(day, month, year);
    }

    public String calculateAge() {
        int year = getYearFromDate(dateOfBirth);
        DateOfBirthCalculator dobCalculator = new DateOfBirthCalculator();
        return dobCalculator.calculateDateOfBirth(year);
    }

    public String calculateElement() {
        int year = getYearFromDate(dateOfBirth);
        FiveElementsCalculator elementsCalculator = new FiveElementsCalculator();
        return elementsCalculator.calculateFiveElements(year);
    }

    public String ZodiacCalculator() {
        int day = getDayFromDate(dateOfBirth);
        int month = getMonthFromDate(dateOfBirth);
        ZodiacCalculator zodiacCalculator = new ZodiacCalculator();
        return zodiacCalculator.calculateZodiacSign(day, month);
    }

    public String calculateZodiacSign() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calculateZodiacSign'");
    }

    // public String saveResult() {
    // }
}