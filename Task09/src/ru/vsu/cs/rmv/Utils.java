package ru.vsu.cs.rmv;

import UtilsSolomatin.SwingUtils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Utils {
    public static ArrayList<Integer> StringToList(String str) throws FileNotFoundException {

        ArrayList<Integer> list = new ArrayList<Integer>();
        String[] massivElemFromString = str.split(" ");

        for (String number : massivElemFromString) {
            list.add(Integer.parseInt(number));
        }
        return list;
    }

    public static ArrayList<Integer> readListFromFile(String path) throws FileNotFoundException {
        FileReader fr = new FileReader(path);
        Scanner scanner = new Scanner(fr);

        ArrayList<Integer> list = new ArrayList<Integer>();
        String str = scanner.nextLine();
        return StringToList(str);
    }

    public static String listToString(ArrayList<Integer> list, String itemFormat) {
        if (list == null) {
            return null;
        }
        if (itemFormat == null || itemFormat.length() == 0) {
            itemFormat = "%s";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (i > 0) {
                sb.append(" ");
            }
            sb.append(String.format(Locale.ROOT, itemFormat, list.get(i)));
        }
        return sb.toString();
    }

    public static InputArgs parseCmdArgs(String[] args) {
        String windowOrCmd = args[0];
        String inputFilePath = args[1];

        return new InputArgs(inputFilePath, windowOrCmd);
    }

    public static void winMain() throws Exception { // запуск приложения
        Locale.setDefault(Locale.ROOT);
        SwingUtils.setDefaultFont("Microsoft Sans Serif", 20);

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameMain().setVisible(true);
            }
        });
    }
}
