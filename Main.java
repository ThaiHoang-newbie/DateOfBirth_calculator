import java.util.Scanner;
import validations.InputValidator;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String personName = scanner.nextLine();
        System.out.print("Enter your day of birth (e.g., 01): ");
        int dayOfBirth = scanner.nextInt();
        System.out.print("Enter your month of birth (e.g., 01): ");
        int monthOfBirth = scanner.nextInt();
        System.out.print("Enter your year of birth (e.g., 2000): ");
        int yearOfBirth = scanner.nextInt();

        Person person = new Person(personName, dayOfBirth, monthOfBirth, yearOfBirth);

        if (!InputValidator.isValidDay(dayOfBirth, monthOfBirth, yearOfBirth) ) {
            System.out.println("Invalid date of birth, please check again");
        } else {
            System.out.println(person.getName() + " has " + person.calculateAge() + " age, " + person.calculateElement() + " element, "
                    + "and " + person.ZodiacCalculator() + " zodiac ");
        }
    }
}
