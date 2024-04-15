package controllers;

import interfaces.Zodiac;

public class ZodiacCalculator implements Zodiac {

    @Override
    public String calculateZodiacSign(int day, int month) {
        int zodiac = (day + month) % 12;

        switch (zodiac) {
            case 0:
                return "Song Ngu";
            case 1:
                return "Bach Duong";
            case 2:
                return "Kim Nguu";
            case 3:
                return "Song Tu";
            case 4:
                return "Cu Giai";
            case 5:
                return "Su Tu";
            case 6:
                return "Xu Nu";
            case 7:
                return "Thien Binh";
            case 8:
                return "Thien Yet";
            case 9:
                return "Nhan Ma";
            case 10:
                return "Ma Ket";
            case 11:
                return "Bao Binh";
            default:
                return "Invalid";
        }
    }
}
