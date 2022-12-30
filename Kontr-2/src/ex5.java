import java.util.*;

public class ex5 {
    public static void main(String[] args){
        List<Integer> list = Arrays.asList(3, 7, 1, 3, 5, 1, 6, 1, 7, 7, 2, 5);
        Map<Integer, List<Integer>> mapOfList = solve(list);
        System.out.println(mapOfList);
    }
    public static Map<Integer, List<Integer>> solve(List<Integer> list){
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> values = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i), getValues(list, i));
        }

        return map;
    }

    public static List<Integer> getValues(List<Integer> list, int index){
        List<Integer> values = new ArrayList<>();
        int firstIndex = 0;
        int twoIndex = 0;
        for (int j = 0; j < list.size(); j++) {
            if(Objects.equals(list.get(index), list.get(j))){
                firstIndex = j;
                break;
            }
        }

        for (int j = 0; j < list.size(); j++) {
            if(Objects.equals(list.get(index), list.get(j))){
                twoIndex = j;
            }
        }
        if(firstIndex == twoIndex){
            values.add(firstIndex);
        }
        else{
            values.add(firstIndex);
            values.add(twoIndex);
        }

        return values;
    }
}
