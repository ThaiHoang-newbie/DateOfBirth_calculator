package controllers;

import interfaces.DateOfBirth;

public class DateOfBirthCalculator implements DateOfBirth {
    private final String[] DATE_CYCLE = {"Canh", "Tan", "Nham", "Quy", "Giap", "At", "Binh", "Dinh", "Mau", "Ky"};
    private final String[] CHINESE_ZODIAC  = {"Ty", "Suu", "Dan", "Mao", "Thin", "Ty.", "Ngo", "Mui", "Than", "Dau", "Tuat", "Hoi"};

    // link: https://maivangrongviet.vn/cach-tinh-menh-ngu-hanh
    @Override
    public String calculateDateOfBirth(int year) {
        String dateCycleString = DATE_CYCLE[year % 10];
        String chineseZodiacString = CHINESE_ZODIAC[(year - 4) % 12];


        return dateCycleString + " " + chineseZodiacString;
    }
}
