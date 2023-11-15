package helper;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.IOException;

public class JSONReader {

    public static String getTestData(String key) throws IOException, ParseException {

        String testData;
        return testData = (String) getJSONData().get(key); //input is the key
    }



    public static JSONObject getJSONData() throws IOException, ParseException {
        //go to the file location
        File filename = new File("resources/TestData/testdata.json");
        //how to read json file
        //first convert to string
        String jsonString = FileUtils.readFileToString(filename,"UTF-8");
        //then convert(parsing) string to JSON object
        Object jsonParsed = new JSONParser().parse(jsonString);
        //then conver to JSON Object
        JSONObject jsonObj = (JSONObject) jsonParsed;

        return jsonObj;
    }
}
