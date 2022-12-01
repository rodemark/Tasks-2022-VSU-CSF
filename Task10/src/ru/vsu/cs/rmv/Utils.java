package ru.vsu.cs.rmv;

import UtilsSolomatin.SwingUtils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Utils {
    public static ArrayList<ArrayList<String>> readFromFile(String path, int studentsAmount) throws FileNotFoundException { // чтение двумерного списка из файла со строками
        FileReader fr = new FileReader(path);
        Scanner scanner = new Scanner(fr);

        String[] str;
        ArrayList<ArrayList<String>> lists = new ArrayList<>();
        ArrayList<String> newList = new ArrayList<>();

        str = scanner.nextLine().split(",");
        studentsAmount = Integer.parseInt(str[0]);

        for (int i = 0; i < studentsAmount; i++) {
            str = scanner.nextLine().split(",");

            newList.addAll(Arrays.asList(str));

            lists.add(newList);

            newList = new ArrayList<>();
        }

        scanner.close();
        return lists;
    }
    public static ArrayList<ArrayList<String>> listsSorted(ArrayList<ArrayList<String>> lists){ //сортировка списка по среднему баллу
        boolean isSorted = false;
        ArrayList<String> buf;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < lists.size() - 1; i++) {
                if(Double.parseDouble(lists.get(i).get(3)) > Double.parseDouble(lists.get(i + 1).get(3))){
                    isSorted = false;

                    buf = lists.get(i);
                    lists.set(i, lists.get(i + 1));
                    lists.set(i + 1, buf);
                }
            }
        }
        return lists;
    }

    public static String[][] listToArray(ArrayList<ArrayList<String>> lists){
        String[][] arr = new String[lists.size()][lists.get(0).size()];
        for(int i = 0; i < lists.size(); i++){
            for (int j = 0; j < lists.get(i).size(); j++){
                arr[i][j] = lists.get(i).get(j);
            }
        }
        return arr;
    }

    public static ArrayList<ArrayList<String>> arrayToList(String[][] arr){

        ArrayList<ArrayList<String>> lists = new ArrayList<ArrayList<String>>();
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[0].length; j++){
                list.add(arr[i][j]);
            }
            lists.add(list);
            list = new ArrayList<>();
        }
        return lists;
    }
    public static InputArgs parseCmdArgs(String[] args) {
        String windowOrCmd = args[0];
        String inputFilePath = args[1];
        String minAmountStudents = args[2];
        String minPointAverage = args[3];

        return new InputArgs(windowOrCmd, inputFilePath, minAmountStudents, minPointAverage);
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
