package coursera.algorithm.unionfind.variants;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SocialNetworkConnectivityProblem {

	/*
	 * Given a social network containing n members and a log file containing m
	 *  timestamps at which times pairs of members formed friendships, 
	 *  design an algorithm to determine the earliest time at which all members are connected 
	 *  (i.e., every member is a friend of a friend of a friend ... of a friend). 
	 *  Assume that the log file is sorted by timestamp
	 */
	
	int[] arr;
	int[] sz;
	int componentCount = 0;
	
	List<Date> timestamps = new ArrayList<>();
	
	public SocialNetworkConnectivityProblem(int size) {
		arr = new int[size];
		sz = new int[size];
		for (int i=0; i<size; i++) {
			arr[i] = i;
			sz[i] = 1;
		}
		componentCount = size;
	}
	
	public void connect(int a, int b) {
		System.out.println("Connecting ..."+a+ "  and "+b);		
		Integer x = root(a);
		Integer y = root(b);
		if (x != y) {
			timestamps.add(new Date());
			componentCount --;
			if (sz[x] < sz[y]) {
				arr[x] = y;
				sz[y] = sz[x]+ sz[y];
			} else {
				arr[y] = x;
				sz[x] = sz[x] + sz[y];
			}
			if (componentCount == 1) {
				System.out.println("All elements are interconnected at "+ timestamps.get(timestamps.size()-1));
			}
		}

	}
	
	protected boolean isRoot(int i) {
		return arr[i] == i;
	}
	
	protected int root(int i) {
		if (isRoot(i)) {
			return i;
		} else {
			return root(arr[i]);
		}
	}
	
	public static void main(String[] args) {
		SocialNetworkConnectivityProblem test = new SocialNetworkConnectivityProblem(10);
		test.connect(1, 2);
		test.connect(3, 4);
		test.connect(5, 6);
		test.connect(7, 8);
		test.connect(2, 8);
		test.connect(5, 9);
		test.connect(0, 7);
		test.connect(4, 5);
		test.connect(6, 7);
		test.connect(8, 9);
	}
}
