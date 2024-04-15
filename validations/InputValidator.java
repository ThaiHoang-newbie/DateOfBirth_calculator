package validations;

public class InputValidator {
    public static boolean isValidDay(int day, int month, int year) {
        int maxDay;

        switch (month) {
            case 2:
                if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                    maxDay = 29;
                } else {
                    maxDay = 28;
                }
            case 4, 6, 9, 11:
                maxDay = 30;
                break;
            default:
                maxDay = 31;
                break;
        }
        return day <= maxDay;
    }
}
