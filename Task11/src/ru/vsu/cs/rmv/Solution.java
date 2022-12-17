package ru.vsu.cs.rmv;

import java.util.*;

public class Solution {
    private static boolean checkThreeEqualsLetters(String word){
        Map<String, Integer> letters = new HashMap<String, Integer>();
        String[] arrayLetters = word.split("");

        for(int i = 0; i < arrayLetters.length; i++){
            if(!letters.containsKey(arrayLetters[i])){
                letters.put(arrayLetters[i], 1);
            }
            else{
                int value = letters.get(arrayLetters[i]);
                letters.put(arrayLetters[i], ++value);
                if(value++ >= 3){
                    return true;
                }
            }

        }
        return false;

//        String[] letters = word.split("");
//        int count;
//        for (int i = 0; i < letters.length; i++){
//
//        }

//            Pattern pattern = Pattern.compile(letters[i]);
//            Matcher matcher = pattern.matcher(word);
//            int n = 0;
//
//            while (matcher.find()) {
//                n++;
//                if (n >= 3){
//                    return true;
//                }
//            }
//        }
//    return false;
    }
    public static HashSet<String> solving(String[] textFromFile){
        HashSet<String> words = new HashSet<>();
        for (String s : textFromFile) {
            if (checkThreeEqualsLetters(s)) {
                words.add(s);
            }
        }
        return words;
    }
}
