package org.example;
import java.io.IOException;
import static org.example.ReadTokenize.readntokenize;
import static org.example.ReadTokenize.readntokenizeV2;

public class Main {
    public static void main(String[] args) {
        try {
            readntokenize();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}