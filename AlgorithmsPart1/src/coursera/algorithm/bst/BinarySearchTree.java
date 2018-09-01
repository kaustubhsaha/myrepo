package coursera.algorithm.bst;

public class BinarySearchTree<V extends Comparable<V>> {

	private Node<V> root;
	
	public Node<V> search(V value){
		return search(root, value);
	}
	
	protected Node<V> search(Node<V> node, V value){
		if (node == null || value == null) {
			return null;
		}
		
		int cmp = value.compareTo(node.getValue());
		
		if (cmp < 0) {
			return search (node.getLeft(), value);
		}
		else if (cmp > 0) {
			return search (node.getRight(), value);
		}
		else {
			return node;
		}
	}
	
	public void add(V value) {
		root = add(root, value);
		count(root);
	}
	
	public Node<V> add(Node<V> node, V value) {
		if (node == null) {
			return new Node<>(value);
		}
		
		int cmp = value.compareTo(node.getValue());
		
		if (cmp < 0) {
			node.left = add(node.left, value);
		}
		else if (cmp > 0) {
			node.right = add(node.right, value);
		}
		else {
			node.setValue(value); 
			node.count = 1 + size(node.left) + size(node.right);
		}
		
		return node;
	}
	
	public int size(Node<V> node) {
		if (node == null) {
			return 0;
		}
		else {
			return node.count;
		}
	}
	
	public int count(Node<V> node) {
		if (node == null) {
			return 0;
		}
		node.count = 1 + count(node.left) + count(node.right);
		return node.count;
	}
	
	public int rank(V value) {
		return rank(root, value);
	}
	
	protected int rank(Node<V> node, V value) {
		int cmp = value.compareTo(node.value);
		if (cmp < 0) {
			return rank(node.left, value);
		}
		else if (cmp > 0) {
			return rank(node.right, value) + size(node.left) + 1;
		}
		else {
			return size(node.left);
		}
	}
	
	protected void visit(Node<V> node) {
		System.out.println("Node "+node+ " value: "+node.value);
	}
	
	protected void inorder(Node<V> node) {
		if (node == null)
			return;
		inorder(node.left);
		visit(node);
		inorder(node.right);
	}
	
	protected void preorder(Node<V> node) {
		if (node == null)
			return;		
		visit(node);
		preorder(node.left);
		preorder(node.right);
	}
	
	protected void postorder(Node<V> node) {
		if (node == null)
			return;		
		postorder(node.left);
		postorder(node.right);
		visit(node);
	}
	
	public void inorder() {
		inorder(root);
	}
	
	public void preorder() {
		preorder(root);
	}
	
	public void postorder() {
		postorder(root);
	}
	
	public V floor(V value) {
		Node<V> node = floor(root, value);
		return (node == null) ? null : node.value;
	}
	
	protected Node<V> floor(Node<V> node, V value){
		if (node == null) {
			return null;
		}
		int cmp = value.compareTo(node.value);
		if (cmp < 0) {
			return floor(node.left, value);
		}
		else if (cmp > 0) {
			Node<V> tmp = floor(node.right, value);
			if (tmp != null) {
				return tmp;
			}
			else {
				return node;
			}
		}
		else {
			return node;
		}
	}
	
	protected Node<V> deleteMin(Node<V> node){
		if (node.left == null) {
			return node.right;
		}
		else {
			node.left = deleteMin(node.left);
			return node;
		}
	}
	
	public void deleteMin() {
		root = deleteMin(root);
		count(root);
	}
	
	public void delete(V value) {
		root = delete(root, value);
		count(root);
	}
	
	protected Node<V> delete(Node<V> node, V value){
		if (node == null) {
			return null;
		}
		int cmp = value.compareTo(node.value);
		if (cmp < 0) {
			node.left = delete(node.left, value);
		}
		else if (cmp > 0) {
			node.right = delete(node.right, value);
		}
		else {
			Node<V> tmp = node;
			node = min(node.right);
			node.right = deleteMin(tmp.right);
			node.left = tmp.left;
		}
		return node;
	}
	
	public Node<V> min() {
		return min(root);
	}
	
	protected Node<V> min(Node<V> node) {
		if (node == null) {
			return null;
		}
		if (node.left == null) {
			return node;
		}
		else {
			return min(node.left);
		}
	}
	
	public Node<V> max() {
		return max(root);
	}
	
	protected Node<V> max(Node<V> node) {
		if (node == null) {
			return null;
		}
		if (node.right == null) {
			return node;
		}
		else {
			return max(node.right);
		}
	}
}
