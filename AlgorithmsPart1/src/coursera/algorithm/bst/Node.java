package coursera.algorithm.bst;

public class Node<V extends Comparable<V>> {

	protected V value;
	protected Node<V> left;
	protected Node<V> right;
	
	protected int count;
	
	public Node() {	}
	
	public Node(V value) {
		this.value = value;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public Node<V> getLeft() {
		return left;
	}

	public void setLeft(Node<V> left) {
		this.left = left;
	}

	public Node<V> getRight() {
		return right;
	}

	public void setRight(Node<V> right) {
		this.right = right;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	
}
