package src.main.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

//import com.google.gson.*;

class Jsonparsing{
    public static void main(String[] args) {

        try {
            URL url = new URL("https://raw.githubusercontent.com/arcjsonapi/ApiSampleData/master/api/users");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

//            URLConnection conn =  url.openConnection();
//            conn.connect();

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            StringBuilder sb = new StringBuilder();
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                //System.out.println(output);
                sb = sb.append(output).append("\n");
            }
            System.out.println(sb.toString());
            InputStreamReader ins = new InputStreamReader((conn.getInputStream()));
            conn.disconnect();

//            JsonParser jsonParser = new JsonParser();
//            JsonElement jsonElement = jsonParser.parse(sb.toString());
//            JsonObject jsonObject = jsonElement.getAsJsonObject();


            Gson gson = new Gson();




        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}