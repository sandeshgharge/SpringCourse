package com.example.dsaExamples;

import java.util.HashSet;
import java.util.Set;

public class SubStringNoCharRepeat {
	
	/**
	 * Longest Substring Without Repeating Characters: Find the length of the longest 
	 * substring without repeating characters.
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		longestSubStringNoRepeatCharacters("dgashga");
		longestSubStringNoRepeatCharacters("abcabcbb");

	}
	
	static void longestSubStringNoRepeatCharacters(String str) {
		
		Set<Character> s = new HashSet<Character>();
		int left=0, right=0, n=str.length(), maxLen = 0;
		
		while(left<n && right<n) {
			
			char c = str.charAt(right);
			while(s.contains(c)) {
				s.remove(str.charAt(left));
				left++;
			}
			s.add(c);
			
			right++;
			maxLen = Math.max(maxLen, right-left);
		}
		
		System.out.println(maxLen);
	}

}
