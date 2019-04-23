package coursera.algorithm.queue;

import org.junit.Assert;

import coursera.algorithm.linkedlist.Node;

public class QueueUsingLinkedList<V> implements Queue<V> {

	protected Node<V> head;
	protected Node<V> tail;
	
	@Override
	public void enqueue(V val) {
		Node<V> node = new Node<>(val);
		if (tail != null) {
			tail.setNext(node);
		} else {
			head = node;
		}
		tail = node;
	}

	@Override
	public V dequeue() {
		if (head == null) {
			throw new IllegalStateException("Cant remove elements off an empty queue");
		}
		V val = head.getValue();
		head = head.getNext();
		return val;
	}

	public static void main(String[] args) {
		Queue<Integer> test = new QueueUsingLinkedList<>();
		test.enqueue(1);
		test.enqueue(2);
		test.enqueue(3);
		
		Assert.assertEquals(1, test.dequeue().intValue());
		test.enqueue(4);
		test.enqueue(5);
		
		Assert.assertEquals(2, test.dequeue().intValue());
		Assert.assertEquals(3, test.dequeue().intValue());
		Assert.assertEquals(4, test.dequeue().intValue());
		Assert.assertEquals(5, test.dequeue().intValue());
	}
}
