package coursera.algorithm.unionfind;

import org.junit.Assert;

public class OptimizedQuickUnion extends QuickUnion {

	private int[] sz;
	
	public OptimizedQuickUnion (int size) {
		super(size);
		sz = new int[size];
		for (int i=0; i<sz.length; i++) {
			sz[i] = 1;
		}
	}
	
	@Override
	public void union(Integer a, Integer b) {
		Integer x = root(a);
		Integer y = root(b);
		if (sz[x] < sz[y]) {
			arr[x] = y;
			sz[y] = sz[x]+ sz[y];
		} else {
			arr[y] = x;
			sz[x] = sz[x] + sz[y];
		}
	}
	
	public static void main(String[] args) {
		UnionFind<Integer> test = new OptimizedQuickUnion(10);
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
