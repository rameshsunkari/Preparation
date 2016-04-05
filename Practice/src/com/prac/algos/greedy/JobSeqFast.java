package com.prac.algos.greedy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class JobSeqFast {
	private static class Item implements Comparable {
		private int profit;
		private int deadline;
		private String name;

		public Item(int p, int d, String n) {
			profit = p;
			deadline = d;
			name = n;
		}

		public int compareTo(Object o) {
			Item other = (Item) o;
			if (profit > other.profit) // Descending sort
				return -1;
			else if (profit < other.profit)
				return 1;
			else
				return 0;
		}

		public int getProfit() {
			return profit;
		}

		public void setProfit(int profit) {
			this.profit = profit;
		}

		public int getDeadline() {
			return deadline;
		}

		public void setDeadline(int deadline) {
			this.deadline = deadline;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

	}

	/*public static int[] fjs(Item[] jobs, int b) {
		int n = jobs.length;
		int[] j = new int[n]; // Profit max jobs, in time order
		Set jobSet = new HashSet(b);

		int[] f = new int[b]; // Highest free slot, job due at i

		for (int i = 0; i < b; i++)

			f[i] = i; // Sentinel at jobs[0]
		for (int i = 1; i < n; i++) { // Jobs in profit order
//			int q = jobSet.contains(Math.min(n, jobs[i].deadline));
			if (f[q] != 0) { // If free slot exists
				int q[] = i; // Add job in that slot
//				int m = jobSet.collapsingFind(f[q] - 1); // Find earlier slot
				jobSet.weightedUnion(m, q); // Unite sets
				f[q] = f[m]; // In case q is root, not m
			}

		}

		return j; // Jobs in optimal set

	}*/

	public static void main(String args[]) {
		Item sentinel = new Item(0, 0, "s");// Don’t sort-leave in place
		Item a = new Item(100, 2, "a"); // Also create b, c, d, e
		Item b = new Item(19, 1, "b");
		Item c = new Item(27, 2, "c");
		Item d = new Item(25, 1, "d");
		Item e = new Item(3, 3, "e");
		Item[] jobs = { sentinel, a, b, c, d, e };
		Arrays.sort(jobs, 1, jobs.length - 1); // Sort descending
		int maxD = -1; // Maximum deadline
		for (Item i : jobs)
			if (i.deadline > maxD)
				maxD = i.deadline;

		maxD++;

		/*int bb = Math.min(maxD, jobs.length);

		int[] j = fjs(jobs, bb);

		System.out.println("Jobs done:");

		for (int i = 1; i < maxD; i++) {

			if (j[i] > 0) {
				System.out.println(" Job " + jobs[j[i]].name + " at time " + i);
			}
		}*/
	}
}