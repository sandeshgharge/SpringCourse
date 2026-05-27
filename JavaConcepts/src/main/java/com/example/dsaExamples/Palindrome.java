package com.example.dsaExamples;

public class Palindrome {
	
	/**
	 * Palindrome Check: Determine if a given string is a palindrome.
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "namman";
		
		System.out.println(checkIfPalindrome(str));

	}
	
	static boolean checkIfPalindrome(String str) {
		int n = str.length();
		
		for(int i = 0; i< n/2; i++) {
			if(str.charAt(i) == str.charAt(n-1-i)) {
				continue;
			}
			else return false;
		}
		
		return true;
	}

}
