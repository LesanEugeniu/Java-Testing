package com.testingservice.utility;

import java.io.*;
import java.util.List;

public class Writer {
    public static void writeToFile(List<String> arr) {
        FileWriter writer = null;
        try {
            writer = new FileWriter("src/test/resources/results/TenResults.out");
            writer.write("===XPATH===\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int k = 0;
        for (String str : arr) {
            k++;
            try {
                if(k==6) writer.write("===CSS SELECTORS===\n");
                writer.write(str + System.lineSeparator());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
