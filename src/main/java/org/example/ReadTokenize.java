package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ReadTokenize {
    static Map<String, ArrayList<String>> terms = new TreeMap<>();
    static Map<String, SortedMap<String, Integer>> termsV2 = new TreeMap<>();
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

    public static void readntokenizeV2() throws IOException {

        File folder = new File("src/main/resources");
        File[] files = folder.listFiles();

        assert files != null;
        for (File file : files) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] tokens = line.split(" ");
                    for (String token : tokens) {
                        if (token.contains(".") || token.contains(",") || token.contains("!") ||
                                token.contains("?") || token.contains(":") || token.contains(";") ||
                                token.contains("'") || token.contains("\"")) {
                            token = token.replaceAll(willIgnore, "");
                        }

                        token = token.toLowerCase();
                        String filename = file.getName().split("\\.")[0];
                        if (termsV2.containsKey(token)) {
                            if (termsV2.get(token).containsKey(filename)) {
                                termsV2.get(token).put(filename, termsV2.get(token).get(filename) + 1);
                            } else {
                                termsV2.get(token).put(filename, 1);
                            }

                        } else {
                            termsV2.put(token, new TreeMap<>());
                            termsV2.get(token).put(filename, 1);
                        }

                    }
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        for (Map.Entry<String, SortedMap<String, Integer>> entry : termsV2.entrySet()) {
            System.out.print(entry.getKey() + " --> ");

            for (Map.Entry<String, Integer> docs : entry.getValue().entrySet()) {
                System.out.print("(" + docs.getKey() + ": " + docs.getValue() + ") ");
            }

            System.out.println();
        }
    }

}
