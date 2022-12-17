package ru.vsu.cs.rmv;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Utils {
    public static String[] readArrayStringFromFile(String path) throws FileNotFoundException {
        FileReader fr = new FileReader(path);
        Scanner scanner = new Scanner(fr);
        return scanner.nextLine().split("\\s*(\\s|\\d|,|!|\\.)\\s*");
    }

}
