package com.example.dsaExamples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeTwoSortedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> a = Arrays.asList(2,4,7,8,9);
		List<Integer> b = Arrays.asList(1,3,4,5,7);
		
		
		System.out.println(mergeTwoListLoop(a, b).toString());
	}
	
	static List<Integer> mergeTwoListLoop(List<Integer> a, List<Integer> b) {

		List<Integer> res = new ArrayList<Integer>();
		int an= a.size(), bn = b.size();
		int i = 0, j = 0 ;
		
		while(i<an && j <bn) {
			
			if(a.get(i) > b.get(j)) {
				res.add(b.get(j));
				j++;
			}
			else if(a.get(i) < b.get(j)) {
				res.add(a.get(i));
				i++;
			}
			else {
				res.add(a.get(i));
				i++;
				j++;
			}
		}
		System.out.println(i);
		System.out.println(j);
		System.out.println(res.toString());
		
		if(i == an) {
			res.addAll(i+1, b.subList(j, bn));
		}
		else if(j == bn) {
			res.addAll(j+1, a.subList(i, an));
		}
		return res;
		
	}
}
