package week5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneNumberCombination {
    // Mapping of digits to letters
    private Map<Character, String> phoneMap = new HashMap<>();

    public PhoneNumberCombination() {
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");
    }

    private void backtrack(List<String> combinations, String digits, int index, StringBuilder currentCombination) {
        if (index == digits.length()) {
            combinations.add(currentCombination.toString());
            return;
        }

        char digit = digits.charAt(index);
        String letters = phoneMap.get(digit);
        for (char letter : letters.toCharArray()) {
            currentCombination.append(letter);
            backtrack(combinations, digits, index + 1, currentCombination);
            currentCombination.deleteCharAt(currentCombination.length() - 1); // backtrack
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return combinations;
        }
        backtrack(combinations, digits, 0, new StringBuilder());
        return combinations;
    }

    public static void main(String[] args) {
        PhoneNumberCombination solution = new PhoneNumberCombination();

        // test time
        long startTime = System.nanoTime();
        String digits = "6472682569";
        List<String> combinations = solution.letterCombinations(digits);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Duration: " + duration + " nanoseconds");
    }
}
