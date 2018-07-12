package core;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Utils {
    public static JSONObject getJsonObjectFromFile(String path) {
        JSONParser parser = new JSONParser();
        JSONObject json = new JSONObject();

        try {
            json = (JSONObject) parser.parse(new FileReader(path));
        } catch (FileNotFoundException e) {
            // TODO : Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO : Auto-generated catch block
            e.printStackTrace();
        } catch (ParseException e) {
            // TODO : Auto-generated catch block
            e.printStackTrace();
        }
        return json;
    }

    public static JSONArray getJsonArrayFromFile(String path) {
        JSONParser parser = new JSONParser();
        JSONArray json = new JSONArray();

        try {
            json = (JSONArray) parser.parse(new FileReader(path));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return json;
    }
}
