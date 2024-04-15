package controllers;

import interfaces.DateOfBirth;

public class DateOfBirthCalculator implements DateOfBirth {
    private final String[] DATE_CYCLE = {"Giap", "At", "Binh", "Dinh", "Mau", "Ky", "Canh", "Tan", "Nham", "Quy"};
    private final String[] CHINESE_ZODIAC  = {"Ty", "Suu", "Dan", "Mao", "Thin", "Ty", "Ngo", "Mui", "Than", "Dau", "Tuat", "Hoi"};


    @Override
    public String calculateDateOfBirth(int year) {
        String dateCycleString = DATE_CYCLE[(year - 4) % 10];
        String chineseZodiacString = CHINESE_ZODIAC[(year - 4) % 12];
        return dateCycleString + " " + chineseZodiacString;
    }
}
