package com.practice.algo.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PossiblePalindrome131 {

	List<List<String>> result = new ArrayList<List<String>>();

	public List<List<String>> partition(String s) {

		possiblePalindrome(s, 0, new ArrayList<String>(), "");
		return result;
	}

	private void possiblePalindrome(String s, int pos, List<String> subList, String subStr) {

		if (pos == s.length()) {
			if (!subList.isEmpty() && subStr.isEmpty())
				result.add(subList);
			return;
		}

		String x = s.substring(pos, pos + 1);
		if (isPalindrome(subStr + x)) {
			List<String> lst = new ArrayList<>();
			lst.addAll(subList);
			lst.add(subStr + x);
			possiblePalindrome(s, pos + 1, lst, "");
		}
		possiblePalindrome(s, pos + 1, subList, subStr + x);

	}

	private boolean isPalindrome(String x) {
		for (int i = 0; i < x.length() / 2; i++) {
			if (x.charAt(i) != x.charAt(x.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(new PossiblePalindrome131().partition("aab"));
	}

}
