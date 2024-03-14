package com.practice.ds.graphs;

public class DecodeString {

	public String decodeString(String s) {
		int i = 0;
		String str = "";
		String decodedSubStr = "";
		int num = 0;
		while (i < s.length()) {
			if (Character.isDigit(s.charAt(i))) {
				num = Character.getNumericValue(s.charAt(i));
				while (Character.isDigit(s.charAt(i + 1))) {
					num = num * 10 + Character.getNumericValue(s.charAt(++i));
				}
				i++;
			} else if (s.charAt(i) == '[') {
				int open = 1;
				int close = 0;
				String substr = "[";
				i++;
				while (open != close) {
					if (s.charAt(i) == ']') close++;
					if (s.charAt(i) == '[') open++;						
					substr = substr + s.charAt(i++);
				}
				decodedSubStr = decodeString(substr.substring(1, substr.length() - 1));
				for (int j = 0; j < num; j++) {
					str = str + decodedSubStr;
				}
			} else {
				str = str + s.charAt(i++);
			}
		}
		return str;
	}

	public static void main(String[] args) {
		DecodeString str = new DecodeString();
		System.out.println(str.decodeString("10[leetcode]"));
	}

}
