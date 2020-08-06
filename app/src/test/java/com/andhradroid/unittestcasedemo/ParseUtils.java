package com.andhradroid.unittestcasedemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ParseUtils {
    public static String readFile(String fileName) throws IOException {
        StringBuilder b = new StringBuilder();
        BufferedReader reader = null;
        try {
            File file = new File("src/test/resources" + fileName);
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String line;
            while ((line = reader.readLine()) != null) {
                b.append(line);
            }
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
        return b.toString();
    }
}
