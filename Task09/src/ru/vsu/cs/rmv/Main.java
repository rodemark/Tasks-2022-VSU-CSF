package ru.vsu.cs.rmv;

import java.util.ArrayList;
public class Main {
    public static void main(String[] args) throws Exception {
        if(args[0].equals("--window")){
            Utils.winMain();
        }

        if(args[0].equals("--cmd")){
            InputArgs inputArgs = Utils.parseCmdArgs(args);
            try{
                ArrayList<Integer> result = Solution.createNewList(Utils.readListFromFile(inputArgs.getInputFilePath()));
                System.out.println(Utils.readListFromFile(inputArgs.getInputFilePath()));
                System.out.println(result);
            }
            catch (Exception FileNotFoundException){
                System.out.println("Invalid path or file type!");
            }

        }
        if(!args[0].equals("--window") && !args[0].equals("--cmd")) {
            System.out.println("Invalid arguments");
        }
    }
}
/*

 */