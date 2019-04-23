package coursera.algorithm.stack;

import coursera.algorithm.linkedlist.Node;
import org.junit.Assert;

public class StackUsingLinkedList<V> implements Stack<V> {

	protected Node<V> head;

	@Override
	public void push(V val) {
		Node<V> tmp = new Node<>(val);
		if (head != null) {
			tmp.setNext(head);
		}
		head = tmp;
		
	}

	@Override
	public V pop() {
		V value = head.getValue();
		head = head.getNext();
		return value;
	}
	
	public boolean isEmpty() {
		return head != null;
	}
	
	public static void main(String[] args) {
		Stack<Integer> test = new StackUsingLinkedList<>();
		test.push(1);
		test.push(2);
		test.push(3);
		
		Assert.assertEquals(3, test.pop().intValue());
		test.push(4);
		test.push(5);
		
		Assert.assertEquals(5, test.pop().intValue());
		Assert.assertEquals(4, test.pop().intValue());
		Assert.assertEquals(2, test.pop().intValue());
		Assert.assertEquals(1, test.pop().intValue());
	}
	
	
}
