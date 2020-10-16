package com.practice.algo.backtracking;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PhoneNumberCombinations17 {

	public List<String> letterCombinations(String digits) {

		List<String> result = new LinkedList<String>();
		if (digits.equals("")) {
			return result;
		}
		Map<Character, List<String>> map = new HashMap<>();
		map.put('1', Arrays.asList(""));
		map.put('2', Arrays.asList("a", "b", "c"));
		map.put('3', Arrays.asList("d", "e", "f"));
		map.put('4', Arrays.asList("g", "h", "i"));
		map.put('5', Arrays.asList("j", "k", "l"));
		map.put('6', Arrays.asList("m", "n", "o"));
		map.put('7', Arrays.asList("p", "q", "r", "s"));
		map.put('8', Arrays.asList("t", "u", "v"));
		map.put('9', Arrays.asList("w", "x", "y", "z"));
		combination(map, result, 0, digits, "");
		return result;
	}

	private void combination(Map<Character, List<String>> map, List<String> result, int pos, String digits,
			String subString) {

		if (pos == digits.length()) {
			result.add(subString);
			return;
		}
		char ch = digits.charAt(pos);
		List<String> lst = map.get(ch);
		for (String val : lst)
			combination(map, result, pos + 1, digits, subString + val);

	}

	public static void main(String[] args) {
		PhoneNumberCombinations17 pc = new PhoneNumberCombinations17();
		System.out.println(pc.letterCombinations("22"));
	}

}
