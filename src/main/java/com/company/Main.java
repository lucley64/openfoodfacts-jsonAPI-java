package com.company;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Main {

    public static void main(String[] args) {
        try {
            InputStream inputStream = new URL("https://world.openfoodfacts.org/api/v0/product/737628064502.json").openStream();
            Files.copy(inputStream, Paths.get("737628064502.json"), StandardCopyOption.REPLACE_EXISTING);

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
