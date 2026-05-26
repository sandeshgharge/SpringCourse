package com.example.javaconcepts;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingChar {
	
	public static void main(String[] args) {
		String input = "Swi$$ sW!ss@123 aA";// find first non-repeated character using java 8
		Map<Character, Integer> tempMap = new LinkedHashMap<Character, Integer>();
		Character res = 49;
		
		for(char c : input.toCharArray()){
			
			tempMap.put(c, tempMap.getOrDefault(c,0) + 1);
		}
		
		for(Map.Entry<Character, Integer> entry : tempMap.entrySet()) {
			if(entry.getValue() == 1) {
				res = entry.getKey();
			}
		}
		
		System.out.println("REsult:" + res);
		
		String str = "Swi$$ sW!ss@123 aA";
        System.out.println(firstNonRepeating(str));
	}
	
	public static Character firstNonRepeating(String str) {
        Map<Character, Integer> freq = new LinkedHashMap<>();

        // Count characters case-insensitively
        for (char ch : str.toCharArray()) {
            char lower = Character.toLowerCase(ch);
            freq.put(lower, freq.getOrDefault(lower, 0) + 1);
        }

        // Find first non-repeating character
        for (char ch : str.toCharArray()) {
            if (freq.get(Character.toLowerCase(ch)) == 1) {
                return ch; // return original character
            }
        }

        return null;
    }

}
