package controllers;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import interfaces.Searchable;

public class JSONSearch implements Searchable {
    private JSONArray jsonArray;

    public JSONSearch(String filePath) throws FileNotFoundException, IOException, ParseException {
        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader(filePath));
            this.jsonArray = (JSONArray) obj;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> searchByName(String name) {
        return search("name", name);
    }

    @Override
    public List<String> searchByZodiac(String zodiac) {
        return search("zodiac", zodiac);
    }

    @Override
    public List<String> searchByAgeCircle(String ageCircle) {
        return search("age_circle", ageCircle);
    }

    @Override
    public List<String> searchByElement(String element) {
        return search("element", element);
    }

    private List<String> search(String key, String value) {
        List<String> results = new ArrayList<>();

        for (Object o : jsonArray) {
            JSONObject jsonObject = (JSONObject) o;

            if (jsonObject.containsKey(key) && jsonObject.get(key).equals(value)) {
                results.add(jsonObject.toString());
            }
        }

        return results;
    }
}