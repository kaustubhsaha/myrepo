package coursera.algorithm.unionfind.variants;

public class UnionFindWithFindLargest {

	/* Add a method find() to the union-find data type so that find(i) returns 
	 * the largest element in the connected component containing i in logarithmic time or better.
	 */

	int[] arr;
	int[] sz;
	int[] max;
	
	public UnionFindWithFindLargest(int size) {
		arr = new int[size];
		sz = new int[size];
		max = new int[size];
		for (int i=0; i<size; i++) {
			arr[i] = i;
			sz[i] = 1;
			max[i] = i;
		}
	}
	
	public void connect(int a, int b) {
		System.out.println("Connecting ..."+a+ "  and "+b);		
		Integer x = root(a);
		Integer y = root(b);
		if (x != y) {
			if (sz[x] < sz[y]) {
				arr[x] = y;
				sz[y] = sz[x]+ sz[y];
			} else {
				arr[y] = x;
				sz[x] = sz[x] + sz[y];
			}
			
			if(max[x] < max[y]) {
				max[x] = max[y];
			}
			else {
				max[y] = max[x];
			}
		}

	}
		
	public int find(int i) {
		return max[root(i)];
	}
	
	public boolean isConnected(int a, int b) {
		return root(a)==root(b);
	}
	
	protected boolean isRoot(int i) {
		return arr[i] == i;
	}
	
	protected int root(int i) {
		if (isRoot(i)) {
			return i;
		} else {
			arr[i]= arr[arr[i]];
			return root(arr[i]);
		}
	}
	
	public static void main(String[] args) {
		UnionFindWithFindLargest test = new UnionFindWithFindLargest(10);
		test.connect(1, 2);
		test.connect(3, 4);
		test.connect(5, 6);
		test.connect(7, 8);
		test.connect(2, 8);
		test.connect(5, 9);
		test.connect(0, 7);

		for (int i=0; i<10; i++) {
			System.out.println(i+". max=>"+test.find(i));
		}
	}

}
