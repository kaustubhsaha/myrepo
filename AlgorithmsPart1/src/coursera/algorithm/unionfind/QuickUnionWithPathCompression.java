package coursera.algorithm.unionfind;

import org.junit.Assert;

public class QuickUnionWithPathCompression extends OptimizedQuickUnion {

	public QuickUnionWithPathCompression(int size) {
		super(size);
	}
	
	@Override
	protected Integer root(Integer i) {
		if (isRoot(i)) {
			return i;
		}
		else {
			arr[i] = arr[arr[i]];
			return root(arr[i]);
		}
	}
	
	public static void main(String[] args) {
		UnionFind<Integer> test = new QuickUnionWithPathCompression(10);
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
