package ru.vsu.cs.rmv;


public class Main {
    public static void main(String[] args) {
        try {
            String path = args[0];
            String[] textFromFile = Utils.readArrayStringFromFile(path);

            for (String s : textFromFile) {
                System.out.print(s + " ");
            }

            System.out.println();
            System.out.println(Solution.solving(textFromFile));

        }
        catch (Exception err) {
            System.out.println("Invalid file path!");
        }
    }
}
