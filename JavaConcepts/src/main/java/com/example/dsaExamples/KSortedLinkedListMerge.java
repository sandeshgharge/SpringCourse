package com.example.dsaExamples;

import java.util.PriorityQueue;

public class KSortedLinkedListMerge {
	
	/**
	 * Given k linkedList merge the all the linkedList in one linkedlist
	 * @param args
	 */
	public static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(5)));
		ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
		ListNode l3 = new ListNode(2, new ListNode(6));

		ListNode[] lists = new ListNode[]{l1, l2, l3};
		mergeKLists(lists);
	}
	
	static ListNode mergeKLists(ListNode[] lists) {
        
		ListNode res = new ListNode();
		boolean allParsed = false;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(
				(a,b) -> a-b
				);
		
		while(!allParsed) {
			allParsed = true;
			for(int i = 0; i<lists.length; i++) {
					if(lists[i] != null) {
						pq.offer(lists[i].val);
						lists[i] = lists[i].next;
						allParsed = false;
					}
			}
		}
		
		res = createSortedListNode(pq);
		

		return res;
    }
	
	static ListNode createSortedListNode(PriorityQueue<Integer> pq){
		
		if(pq.size() > 0) {
			int n = pq.poll();
			return createSortedListNode(pq);
		}
		else
			return new ListNode();
		
	}

}
 