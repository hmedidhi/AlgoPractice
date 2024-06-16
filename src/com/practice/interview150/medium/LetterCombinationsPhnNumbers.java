package com.practice.interview150.medium;

import java.util.*;

public class LetterCombinationsPhnNumbers {

    List<String> result = new LinkedList<>();

    public List<String> letterCombinations(String digits) {
        if(Objects.equals(digits, ""))
            return result;
        Map<Character, List<Character>> map = new HashMap<>();
        map.put('2', Arrays.asList('a', 'b', 'c'));
        map.put('3', Arrays.asList('d', 'e', 'f'));
        map.put('4', Arrays.asList('g', 'h', 'i'));
        map.put('5', Arrays.asList('j', 'k', 'l'));
        map.put('6', Arrays.asList('m', 'n', 'o'));
        map.put('7', Arrays.asList('p', 'q', 'r', 's'));
        map.put('8', Arrays.asList('t', 'u', 'v'));
        map.put('9', Arrays.asList('w', 'x', 'y', 'z'));
        generateString(map, digits, 0,  new StringBuilder());
        return result;
    }

    private void generateString(Map<Character, List<Character>> map, String digits, int n, StringBuilder  endString) {
        if (digits.length() == n) {
            result.add(String.valueOf(endString));
            return;
        }
        for (char c : map.get(digits.charAt(n))) {
            endString.append(c);
            generateString(map,digits,n+1,endString);
            endString.deleteCharAt(endString.length()-1);
        }
    }
}
