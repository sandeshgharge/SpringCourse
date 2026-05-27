package com.example.dsaExamples;

import java.util.HashMap;
import java.util.Map;

public class TwoNumbers {
	
	/**
	 * Two Sum: Given an array of integers, find two numbers that add up to a specific target.
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a [] = {3,4,6,5,7,8};
		twoNumbers(a, 10).toString();
	}

	static int[] twoNumbers(int [] num, int target) {
		
		Map<Integer, Integer> track = new HashMap<Integer, Integer>();
		
		for(int i = 0 ; i<num.length; i++) {
			int complement = target - num[i];
			if(track.containsKey(complement)){
				System.out.println(complement);
				System.out.println(num[i]);
				return new int [] {num[i], complement};
			}
			track.put(num[i], i);
		}
		return new int [] {};
	}
}
