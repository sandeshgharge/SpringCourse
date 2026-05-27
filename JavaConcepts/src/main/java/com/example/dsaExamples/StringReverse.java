package com.example.dsaExamples;

public class StringReverse {
	
	/**
	 * Reverse a String: Write a function to reverse a string without using built-in functions.
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "Hello World!";
		
		System.out.println(usingForEach(str));

	}
	
	static String usingForEach(String str) {
		String res = "";
		for(Character c : str.toCharArray()) {
			res = c + res;
		}
		
		return res;
	}

}
