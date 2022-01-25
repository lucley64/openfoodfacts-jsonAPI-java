package com.company;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParserFactory;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.StringReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try {
            URL url = new URL("https://fr.openfoodfacts.org/api/v0/product/3274080005003.json");
            URLConnection urlConnection = url.openConnection();
            urlConnection.setRequestProperty("User-Agent", "ScanEco - Android - Version 0.1");
            InputStream inputStream = urlConnection.getInputStream();
            Scanner scanner = new Scanner(inputStream);
            String json = scanner.useDelimiter("\\A").next();
            JsonParser parser = Json.createParser(new StringReader(json));

            parser.next();

            System.out.println(parser.getObject().getJsonObject("product").getJsonObject("category_properties").get("ciqual_food_name:fr"));

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
