package coursera.algorithm.stack;

import java.util.Iterator;

import org.junit.Assert;

public class IterableStackUsingArray<V> extends StackUsingArray<V> implements Iterable<V> {

	@Override
	public Iterator<V> iterator() {
		return new StackIterator<>();
	}
	
	class StackIterator<V> implements Iterator<V> {

		@SuppressWarnings("unchecked")
		int current = head;
		
		@Override
		public boolean hasNext() {
			return arr[current+1] != null;
		}

		@Override
		public V next() {
			V val = (V) arr[current++];
			return val;
		}
		
	}
	
	public static void main(String[] args) {
		IterableStackUsingArray<Integer> test = new IterableStackUsingArray<>();
		
		int i = 0;
		while(i < 20) {
			test.push(++i);
		}
		
		int val = 20;
		for (Integer v : test) {
			Assert.assertEquals(val, v.intValue());
			val --;
		}
	}

}
