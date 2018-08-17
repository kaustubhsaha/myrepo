package coursera.algorithm.unionfind;

import org.junit.Assert;

public class QuickFind implements UnionFind<Integer> {

	protected Integer[] arr;
	
	public QuickFind(int size) {
		arr = new Integer[size];
		for (int i=0; i< arr.length; i++) {
			arr[i]=i;
		}
	}
	
	@Override
	public void union(Integer a, Integer b) {
		Integer x = arr[a];
		Integer y = arr[b];
		for (int i=0; i< arr.length; i++) {
			if (arr[i]==x) {
				arr[i]=y;
			}
		}		

	}

	@Override
	public boolean isConnected(Integer a, Integer b) {
		return arr[a]==arr[b];
	}
	
	public static void main(String[] args) {
		UnionFind<Integer> test = new QuickFind(10);
		test.union(1, 2);
		test.union(3, 4);
		test.union(5, 6);
		test.union(7, 8);
		test.union(2, 8);
		test.union(5, 9);
		test.union(0, 7);
		
		Assert.assertTrue(test.isConnected(0, 2));
		Assert.assertTrue(test.isConnected(0, 8));
		Assert.assertFalse(test.isConnected(3, 5));
		Assert.assertTrue(test.isConnected(6, 9));
	}

}
