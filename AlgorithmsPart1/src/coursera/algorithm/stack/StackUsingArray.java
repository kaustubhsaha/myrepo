package coursera.algorithm.stack;

import org.junit.Assert;

import coursera.algorithm.array.ArrayUtils;

public class StackUsingArray<V> implements Stack<V>{
	protected V[] arr;
	protected int head = -1;
	
	public StackUsingArray() {
		arr = (V[]) new Object[16];
	}
	
	@Override
	public void push(V val) {
		arr[++head] = val;
		if (head >= arr.length - 1) {
			arr = ArrayUtils.upsize(arr);
		}
	}
	
	@Override
	public V pop() {
		V val = arr[head];
		arr[head--] = null;
		return val;
	}
	
	public boolean isEmpty() {
		return (head < 0);
	}
	
	public static void main(String[] args) {
		Stack<Integer> test = new StackUsingArray<>();
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
		
		int i = 0;
		while(i < 20) {
			test.push(++i);
		}
		
		i = 0;
		while(i < 20) {
			Assert.assertEquals(20- (i++), test.pop().intValue());
		}
	}
	
}
