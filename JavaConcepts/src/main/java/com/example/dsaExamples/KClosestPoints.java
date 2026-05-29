package com.example.dsaExamples;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class KClosestPoints {
	
	/**
	 * Given array of (x,y), find K closest points to the origin.
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [][] points = {{1,3},{-2,2},{2,2}, {1,4}};
		kClosesPoints(points, 2);
		

	}
	
	static void kClosesPoints(int [][] p, int k) {
		
		Map<int [], Integer> distanceMap = new HashMap<int [], Integer>();
		
		for(int i = 0; i<p.length; i++) {
			int x = p[i][0];
			int y = p[i][1];
			distanceMap.put(p[i], (x*x + y*y));
		}
		
		PriorityQueue<int []> pq = new PriorityQueue<>(
					(a,b) -> b[2] - a[2]
				);
		
		for (int [] key : distanceMap.keySet()) {

            pq.offer(new int[]{key[0], key[1], distanceMap.get(key)});

            if (pq.size() > k) {
                pq.poll();
            }
        }
		
		int[][] result = new int[k][2];

        for (int i = k - 1; i >= 0; i--) {
        	result[i] = pq.poll(); 
        	System.out.println(result[i][0] + "," + result[i][1]);
        }
        
        
	}

}
