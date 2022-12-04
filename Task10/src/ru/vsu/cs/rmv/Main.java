package ru.vsu.cs.rmv;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {

        if(args[0].equals("--window")){
            Utils.winMain();
        }

        if(args[0].equals("-help")){

            System.out.println("""
                    Help:\s
                     args[0] - в окне или в командной строке
                     args[1] - путь к файлу
                     args[2] - количество людей, которое должно остаться
                     args[3] - минимальный средний балл
                    \s""");
        }
        if(args[0].equals("--cmd")){
            InputArgs inputArgs = Utils.parseCmdArgs(args);
            String windowOrCmd = inputArgs.getWindowOrCmd();
            String path = inputArgs.getInputFilePath();
            double pointAverage = Double.parseDouble(inputArgs.getMinPointAverage());
            int minAmountStudents = Integer.parseInt(inputArgs.getMinAmountStudents());


            try{
                ArrayList<ArrayList<String>> lists = Utils.readFromFile(path, 0);
                Utils.listsSorted(lists);

                for(int i = 0; i < lists.size(); i++){
                    System.out.println(lists.get(i));
                }

                System.out.println(" ");

                ArrayList<ArrayList<String>> listsResult = Solution.getListsResult(lists, pointAverage, minAmountStudents);

                for(int i = 0; i < listsResult.size(); i++){
                    System.out.println(listsResult.get(i));
                }

            }
            catch (Exception err){
                System.out.println("Invalid arguments!");
                System.out.println(" ");


            }
        }

    }
}
