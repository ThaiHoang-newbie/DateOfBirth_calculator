package controllers;

import interfaces.FiveElements;

public class FiveElementsCalculator implements FiveElements {
    
    @Override
    public String calculateFiveElements(int year) {
        int lastDigit = year % 10;
        String element = "";
        switch (lastDigit) {
            case 4:
            case 5:
                element = "Mộc";
                break;
            case 6:
            case 7:
                element = "Hoả";
                break;
            case 8:
            case 9:
                element = "Thổ";
                break;
            case 0:
            case 1:
                element = "Kim";
                break;
            case 2:
            case 3:
                element = "Thủy";
                break;
            default:
                element = "Không hợp lệ";
                break;
        }
        return element;

    }
}
