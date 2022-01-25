package com.company;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.net.URL;

public class Main {

    public static void main(String[] args) {
        try {
            BufferedInputStream  inputStream = new BufferedInputStream(new URL("https://world.openfoodfacts.org/api/v0/product/737628064502.json").openStream());
            FileOutputStream outputStream = new FileOutputStream("737628064502.json");
            byte dataBuffer[] = new byte[1024];
            int byteRead;
            while ((byteRead = inputStream.read(dataBuffer, 0 , 1024)) != -1){
                outputStream.write(dataBuffer, 0, byteRead);
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
