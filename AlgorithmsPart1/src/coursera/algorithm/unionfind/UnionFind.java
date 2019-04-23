package coursera.algorithm.unionfind;

public interface UnionFind<T> {

	void union(T a, T b);
	
	boolean isConnected(T a, T b);
}
