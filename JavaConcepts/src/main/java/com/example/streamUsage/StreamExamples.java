package com.example.streamUsage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamExamples {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		fibonacciSeries(10);
//		allElementSame();
		findMaxWithoutSort();

	}
	
	static void fibonacciSeries(int n) {
		
		Stream.iterate(new int[] {0,1}, f -> new int[] {f[1], f[0] + f[1]})
		.limit(n)
		.map(m -> m[0])
		.toList()
		.forEach(System.out::println);
	}
	
	static void allElementSame() {
		List<Integer> l = Arrays.asList(2,2,2,2,2,2,2,2);
		
		boolean flag = l.stream()
		.distinct()
		.allMatch(element -> element == l.get(0));
		
		flag = l.stream()
				.distinct()
				.count() == 1;
		
		System.out.println(flag);
		
	}
	
	static void findMaxWithoutSort() {
		List<Integer> l = Arrays.asList(13,4,5,24,8);
		
		int max = l.stream()
		.max(Integer::compare)
		.orElse(-1);
		
		System.out.println(max);
	}

}
