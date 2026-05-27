package com.example.dsaExamples;

import java.util.Stack;

public class ValidParentheses {
	
	/**
	 * Valid Parentheses: Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
	 * determine if the input string is valid.
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String ip = "(){[]}";
		System.out.println(checkValidParentheses(ip));
	}
	
	static boolean checkValidParentheses(String str){
		
		Stack<Character> cp = new Stack<Character>();
		
		for(Character c : str.toCharArray()) {
			
			if(c == '{' || c == '[' || c == '(') {
				cp.push(c);
			}
			else if(!cp.isEmpty() &&
					((c == '}' && cp.peek() == '{') ||
					(c == ']' && cp.peek() == '[') ||
					(c == ')' && cp.peek() == '('))
					) {
				cp.pop();
			}
			else
				return false;
		}
		
		return cp.isEmpty();
		
	}

}
