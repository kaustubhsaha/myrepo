package coursera.algorithm.stackqueue.variants;

import org.junit.Assert;

import coursera.algorithm.stack.Stack;
import coursera.algorithm.stack.StackUsingArray;

public class StackWithMax<V extends Comparable<V>> implements Stack<V> {

	Stack<V> data = new StackUsingArray<>();
	Stack<V> max = new StackUsingArray<>();
	
	@Override
	public void push(V val) {
		
		if (data.isEmpty()) {
			data.push(val);	
			max.push(val);
		}
		else {
			V maxVal = max.pop();
			max.push(maxVal);
			if (val.compareTo(maxVal) > 0) {			
				max.push(val);
			}
			else {
				max.push(maxVal);
			}
			data.push(val);			
		}
		

	}

	@Override
	public V pop() {
		V val = data.pop();
		max.pop();
		return val;
	}

	@Override
	public boolean isEmpty() {
		return data.isEmpty();
	}
	
	public V max() {
		V val = max.pop();
		max.push(val);
		return val;
	}
	
	public static void main(String[] args) {
		StackWithMax<Integer> test = new StackWithMax<>();
		test.push(1);
		Assert.assertEquals(1, test.max().intValue());
		test.push(2);
		Assert.assertEquals(2, test.max().intValue());
		test.push(3);
		Assert.assertEquals(3, test.max().intValue());
		Assert.assertEquals(3, test.pop().intValue());
		Assert.assertEquals(2, test.max().intValue());
		test.push(4);
		Assert.assertEquals(4, test.max().intValue());
		test.push(5);
		Assert.assertEquals(5, test.max().intValue());
		
		Assert.assertEquals(5, test.pop().intValue());
		Assert.assertEquals(4, test.max().intValue());
		Assert.assertEquals(4, test.pop().intValue());
		Assert.assertEquals(2, test.max().intValue());
		Assert.assertEquals(2, test.pop().intValue());
		Assert.assertEquals(1, test.max().intValue());
		Assert.assertEquals(1, test.pop().intValue());
	}

}
