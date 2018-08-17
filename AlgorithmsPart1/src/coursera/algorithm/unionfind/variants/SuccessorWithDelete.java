package coursera.algorithm.unionfind.variants;

public class SuccessorWithDelete {

	/* Given a set of n integers S = {0,1,2,3,....,n-1} and a sequence of requests of the following form
	 *  Remove x from S
	 *  Find the successor of x: the smallest y in S such that y >= x
	 *  design a data type so that all operations (except construction) take logarithmic time or better in the worst case
	 */
	
	int[] arr;
	int[] sz;
	
	public SuccessorWithDelete(int size) {
		arr = new int[size];
		sz = new int[size];
		for (int i=0; i<size; i++) {
			arr[i] = i;
			sz[i] = 1;
		}
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
			//arr[i] = arr[arr[i]];
			return root(arr[i]);
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
		}
	}
	
	 public void remove(int x) {
		connect(x, x+1);
	 }	  
		
		
	 public int successor(int x) {
		return arr[x];
	 }
	 
	 public static void main(String[] args) {
		    SuccessorWithDelete swd = new SuccessorWithDelete(50);
		    System.out.println(swd.successor(10));
		    swd.remove(11);
		    swd.remove(13);
		    swd.remove(12);
		    swd.remove(10);
		    swd.remove(9);
		    swd.remove(15);
		    System.out.println(swd.successor(8));
		    System.out.println(swd.successor(9));
		    System.out.println(swd.successor(15));
	}
}
