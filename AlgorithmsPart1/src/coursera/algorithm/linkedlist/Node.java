package coursera.algorithm.linkedlist;

public class Node<V> {

	private V value;
	
	private Node<V> next;

	public Node() {
		this(null, null);
	}
	
	public Node(V value) {
		this(value, null);
	}
	
	public Node (V value, Node<V> next) {
		this.value = value;
		this.next = next;
	}
	
	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public Node<V> getNext() {
		return next;
	}

	public void setNext(Node<V> next) {
		this.next = next;
	}
}
