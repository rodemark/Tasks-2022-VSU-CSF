package ru.vsu.cs.rmv;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception {
        if(args[0].equals("--window")){
            Utils.winMain();
        }

        if(args[0].equals("--cmd")){
            InputArgs inputArgs = Utils.parseCmdArgs(args);

            String[][] table = Utils.readFromFile(inputArgs.getInputFilePath());

            String result = Solution.getWinner(table);

            System.out.println(result);
        }

    }
}
