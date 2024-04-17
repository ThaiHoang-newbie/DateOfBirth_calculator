package controllers;

import interfaces.FiveElements;

public class FiveElementsCalculator implements FiveElements {
    private final String[] ELEMENT  = {"Kim", "Thuy", "Hoa", "Tho", "Moc"};

    @Override
    public String calculateFiveElements(int year) {
        int thienCan = 0;
        switch (year % 10) {
            case 4:
            case 5:
                thienCan = 1;
                break;
            case 6:
            case 7:
                thienCan = 2;
                break;
            case 8:
            case 9:
                thienCan = 3;
                break;
            case 0:
            case 1:
                thienCan = 4;
                break;
            case 2:
            case 3:
                thienCan = 5;
                break;
            default:
                break;
        }

        int diaChi = 0;
        switch ((year - 4) % 12) {
            case 0:
            case 1:
            case 6:
            case 7:
                diaChi = 0;
                break;
            case 2:
            case 3:
            case 8:
            case 9:
                diaChi = 1;
                break;
            case 4:
            case 5:
            case 10:
            case 11:
                diaChi = 2;
                break;
            default:
                break;
        }
        int indexElement = (thienCan + diaChi) > 5 ? (thienCan + diaChi) - 5 : (thienCan + diaChi); 
        String element = ELEMENT[indexElement - 1];
        return element;

    }
}
