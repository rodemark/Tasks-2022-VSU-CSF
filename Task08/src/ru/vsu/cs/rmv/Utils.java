package ru.vsu.cs.rmv;

import UtilsSolomatin.SwingUtils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Utils {
    public static String[][] readFromFile(String path) throws FileNotFoundException { // чтение двумерного массива из файла со строками
        FileReader fr = new FileReader(path);
        Scanner scanner = new Scanner(fr);

        int row = 20;
        int column = 20;


        String[][] arr = new String[row][column];
        String[] itemsSpaces = new String[20];

        for (int k = 0; k < 20; k++){
            itemsSpaces[k] = " ";
        }

        for (int i = 0; i < row; i++) {
            String[] items = new String[column];

            try{ // если строка пустая
                items = scanner.nextLine().split("");
            }
            catch (Exception err){
                items = itemsSpaces;

            }

            for (int j = 0; j < 20; j++){
                if(j < items.length){
                    arr[i][j] = items[j];
                }
                if (items.length < 20 && j >= items.length){ // если массив items имеет длину меньше 20
                    arr[i][j] = itemsSpaces[j];
                }
            }
        }
        return arr;
    }



    public static InputArgs parseCmdArgs(String[] args) {
        String windowOrCmd = args[0];
        String inputFilePath = args[1];

        return new InputArgs(inputFilePath, windowOrCmd);
    }

    public static String[][] array20by20(){ // массив 20 на 20 из пробелов
        String[][] table = new String[20][20];
        for (int i = 0; i < 20; i++){
            for(int j = 0; j < 20; j++){
                table[i][j] = " ";
            }
        }
        return table;
    }

    public static void winMain() throws Exception { // запуск приложения
        Locale.setDefault(Locale.ROOT);
        SwingUtils.setDefaultFont("Microsoft Sans Serif", 18);

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameMain().setVisible(true);
            }
        });
    }

}
