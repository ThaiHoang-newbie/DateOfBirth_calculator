package interfaces;

import java.util.List;

public interface Searchable {
    List<String> searchByName(String name);
    List<String> searchByZodiac(String zodiac);
    List<String> searchByAgeCircle(String ageCircle);
    List<String> searchByElement(String element);
}