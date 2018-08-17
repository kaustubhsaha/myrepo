package coursera.algorithm.unionfind;

import org.junit.Assert;

public class QuickUnion implements UnionFind<Integer> {

	protected Integer[] arr;
	
	public QuickUnion( int size) {
		arr = new Integer[size];
		for (int i=0; i< arr.length; i++) {
			arr[i]=i;
		}
	}
	
	protected boolean isRoot(Integer i) {
		return arr[i] == i;
	}
	
	protected Integer root(Integer i) {
		if (isRoot(i)) {
			return i;
		} else {
			return root(arr[i]);
		}
	}
	
	@Override
	public void union(Integer a, Integer b) {
		Integer x = root(a);
		Integer y = root(b);
		arr[x] = y;

	}

	@Override
	public boolean isConnected(Integer a, Integer b) {
		return (root(a) == root(b));
	}
	
	public static void main(String[] args) {
		UnionFind<Integer> test = new QuickUnion(10);
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
