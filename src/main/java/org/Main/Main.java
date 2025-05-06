package org.Main;
import java.io.IOException;

import static org.Main.ReadTokenize.readntokenizeV2;

public class Main {
    public static void main(String[] args) {
        try {
            readntokenizeV2();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}