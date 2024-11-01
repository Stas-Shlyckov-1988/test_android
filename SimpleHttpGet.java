// java -classpath ~/java/json-20240303.jar SimpleHttpGet.java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;
import org.json.JSONArray;

import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class SimpleHttpGet {

    public static void main(String[] args) throws Exception {
        URL url = new URL("http://localhost/api.cgi");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder responseContent = new StringBuilder();
        String inputLine;

        while ((inputLine = reader.readLine()) != null) {
            responseContent.append(inputLine);
        }
        reader.close();

        String str = responseContent.toString();
        Pattern pattern = Pattern.compile("[A-Za-zА-Яа-я0-9_\\-]+");
        Matcher matcher = pattern.matcher(str);
     
        while(matcher.find())
            System.out.println(matcher.group());
       
    }
}
