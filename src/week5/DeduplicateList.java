package week5;

import java.util.ArrayList;
import java.util.List;

public class DeduplicateList {
    public static List<Integer> removeDuplicates(List<Integer> inputList) {
        MyHash<Integer> hash = new MyHash<>();
        List<Integer> uniqueList = new ArrayList<>();

        for (Integer item : inputList) {
            if (!hash.contains(item)) {
                hash.add(item);
                uniqueList.add(item);
            }
        }

        return uniqueList;
    }

    public static void main(String[] args) {
        List<Integer> inputList = List.of(1, 2, 3, 2, 4, 3, 5);
        List<Integer> uniqueList = removeDuplicates(inputList);
        System.out.println(uniqueList);
    }
}
