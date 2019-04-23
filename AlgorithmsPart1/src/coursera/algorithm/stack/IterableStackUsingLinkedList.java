package coursera.algorithm.stack;

import java.util.Iterator;

import org.junit.Assert;

import coursera.algorithm.linkedlist.Node;

public class IterableStackUsingLinkedList<V> extends StackUsingLinkedList<V> implements Iterable<V>{

	@Override
	public Iterator<V> iterator() {
		return new StackIterator<>();
	}
	
	class StackIterator<V> implements Iterator<V> {

		@SuppressWarnings("unchecked")
		Node<V> current = (Node<V>) head;
		
		@Override
		public boolean hasNext() {
			return current.getNext() != null;
		}

		@Override
		public V next() {
			V val = current.getValue();
			current = current.getNext();
			return val;
		}
		
	}
	
	public static void main(String[] args) {
		IterableStackUsingLinkedList<Integer> test = new IterableStackUsingLinkedList<>();
		test.push(1);
		test.push(2);
		test.push(3);
		test.push(4);
		test.push(5);
		
		int val = 5;
		for (Integer v : test) {
			Assert.assertEquals(val, v.intValue());
			val --;
		}
	}

}
