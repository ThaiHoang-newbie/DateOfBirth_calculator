import java.util.Scanner;
import validations.InputValidator;
import controllers.DateOfBirthCalculator;
import controllers.ZodiacCalculator;
import controllers.FiveElementsCalculator;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your day of birth (e.g., 01): ");
        int dayOfBirth = scanner.nextInt();
        System.out.print("Enter your month of birth (e.g., 01): ");
        int monthOfBirth = scanner.nextInt();
        System.out.print("Enter your year of birth (e.g., 2000): ");
        int yearOfBirth = scanner.nextInt();

        if (!InputValidator.isValidDay(dayOfBirth, monthOfBirth, yearOfBirth)) {
            System.out.println("Invalid date of birth, please check again");
        } else {
            // date of birth
            DateOfBirthCalculator dobCalculator = new DateOfBirthCalculator();
            String dateOfBirth = dobCalculator.calculateDateOfBirth(yearOfBirth);
            System.out.println("Your date of birth is: " + dateOfBirth);

            // zodiac
            ZodiacCalculator zodiacCalculator = new ZodiacCalculator();
            String zodiacSign = zodiacCalculator.calculateZodiacSign(dayOfBirth, monthOfBirth);
            System.out.println("Your zodiac sign is: " + zodiacSign);

            // elements
            FiveElementsCalculator elementsCalculator = new FiveElementsCalculator();
            String result = elementsCalculator.calculateFiveElements(dayOfBirth, monthOfBirth, yearOfBirth);
            System.out.println("Your element is: " + result);
        }
    }
}
