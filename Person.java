import controllers.DateOfBirthCalculator;
import controllers.FiveElementsCalculator;
import controllers.ZodiacCalculator;
import validations.InputValidator;

public class Person {
    private String name;
    private int dayOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;
    
    public Person(String name, int dayOfBirth, int monthOfBirth, int yearOfBirth){
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
    }

    public String getName() {
        return name;
    }

    public boolean isValidDateOfBirth() {
        return InputValidator.isValidDay(dayOfBirth, monthOfBirth, yearOfBirth);
    }

    public String calculateAge() {
        DateOfBirthCalculator dobCalculator = new DateOfBirthCalculator();
        return dobCalculator.calculateDateOfBirth(yearOfBirth);
    }

    public String calculateElement() {
        FiveElementsCalculator elementsCalculator = new FiveElementsCalculator();
        return elementsCalculator.calculateFiveElements(dayOfBirth, monthOfBirth, yearOfBirth);
    }

    public String ZodiacCalculator() {
        ZodiacCalculator zodiacCalculator = new ZodiacCalculator();
        return zodiacCalculator.calculateZodiacSign(dayOfBirth, monthOfBirth);
    }
}