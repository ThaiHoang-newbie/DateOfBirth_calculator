package controllers;

import interfaces.FiveElements;

public class FiveElementsCalculator implements FiveElements {
    
    @Override
    public String calculateFiveElements(int day, int month, int year) {
        String[] elements = {"Wood", "Fire", "Earth", "Metal", "Water"};

        int yearElement = (year - 4) % 10;
        if (yearElement < 0) {
            yearElement += 10;
        }

        int monthElement = (month - 1) / 2;
        if (month == 11 || month == 12) {
            monthElement--;
        }

        int dayElement = (day - 1) % 10;
        if (dayElement < 0) {
            dayElement += 10;
        }

        int index = (yearElement + monthElement + dayElement) % 5;
        return elements[index];
    }
}
