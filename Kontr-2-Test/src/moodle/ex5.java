package moodle;

import java.util.*;

public class ex5 {
    public static void main(String[] args){
        List<Integer> list = Arrays.asList(5, 4, 3);
        Map<Integer, Integer> map = solve(list);
        System.out.println(map);
    }

    public static Map<Integer, Integer> solve(List<Integer> list){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            if(!map.containsKey(list.get(i))){
                map.put(list.get(i), 1);
            }
            else{
                int value = map.get(list.get(i));
                map.put(list.get(i), ++value);
            }
        }

        Collection<Integer> values = map.values();
        List<Integer> valuesList = new ArrayList<>(values);

        Map<Integer, Integer> newMap = new HashMap<>();

        int max = -1;

        for (int i = 0; i < valuesList.size(); i++) {
            if (valuesList.get(i) > max){
                max = valuesList.get(i);
            }
        }


        for (int i = 0; i < list.size(); i++) {
            if (max == map.get(list.get(i))){
                newMap.putIfAbsent(list.get(i), i);
            }
        }
        return newMap;
    }
}
