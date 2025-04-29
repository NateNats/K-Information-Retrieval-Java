package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class ReadTokenize {
    static Map<String, ArrayList<String>> terms = new TreeMap<>();
    static String willIgnore = "[.,!?:;'\"]";

    public static void readntokenize() throws IOException {

        File folder = new File("src/main/resources");
        File[] files = folder.listFiles();

        assert files != null; // mengecek apakah variabel tersebut kosong (null) atau tidak.
        for (File file : files) {
            // System.out.println("\n" + file.getName());
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;

                while ((line = reader.readLine()) != null) {
                    String[] tokens = line.split(" ");

                    for (String token : tokens) {
                        if (token.contains(".") || token.contains(",") || token.contains("!") ||
                                token.contains("?") || token.contains(":") || token.contains(";") ||
                                token.contains("'") || token.contains("\"")) {
                            token = token.replaceAll(willIgnore, "");
                            // System.out.println(token);
                        }

                        if (terms.containsKey(token)) {
                            if (!(terms.get(token).contains(file.getName().split("\\.")[0]))) {
                                terms.get(token).add(file.getName().split("\\.")[0]);
                            }

                            // terms.get(token).add(file.getName());
                        } else {
                            terms.put(token, new ArrayList<>());
                            terms.get(token).add(file.getName().split("\\.")[0]);
                        }
                    }
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        for (Map.Entry<String, ArrayList<String>> entry : terms.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

}
