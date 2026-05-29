package com.example.dsaExamples;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class KFreqElements {
	
	/**
	 * Identify k frequent elements in the array
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ar [] = {1,1,2,3,4,5};
		
		topKFrequent(ar, 5);

	}

	public static int[] topKFrequent(int[] nums, int k) {
		
		

        Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
        
        for(int i = 0; i<nums.length; i++) {
        	freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0)+1);
        }
        
        PriorityQueue<int[]> pq =
                new PriorityQueue<>(
                    (a, b) -> a[1] - b[1]
                );
        
        for (int key : freqMap.keySet()) {

            pq.offer(new int[]{key, freqMap.get(key)});

            if (pq.size() > k) {
                pq.poll();
            }
        }

        // Step 4: Build answer
        int[] result = new int[k];

        for (int i = k - 1; i >= 0; i--) {
            result[i] = pq.poll()[0];
            System.out.println(result[i]);
        }
        
        return result;

    }
}
