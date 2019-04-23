package coursera.algorithm.queue;

import org.junit.Assert;

import coursera.algorithm.array.ArrayUtils;
import coursera.algorithm.stack.Stack;
import coursera.algorithm.stack.StackUsingArray;

public class QueueUsingArray<V> implements Queue<V>{

	protected V[] arr;
	protected int head;
	protected int tail;
	
	public QueueUsingArray() {
		arr = (V[])new Object[16];
		
		tail = -1;
		head = -1;
	}
	
	@Override
	public void enqueue(V val) {
		arr[++tail] = val;
		if (tail == 0) {
			++ head;
		}
		else if (tail >= arr.length-1) {
			
			if (head == 0) {
				arr = ArrayUtils.upsize(arr);
			}
			else {
				lshift();
			}
			
		}
	}
	
	
	protected void lshift() {
		for (int i=head; i<=tail; i++) {
			arr[i-head] = arr[i];
		}
		for (int i=(tail-head)+1; i<arr.length; i++) {
			arr[i] = null;
		}
		tail = tail -head;
		head = 0;
	}
	
	@Override
	public V dequeue() {
		V val = arr[head];
		arr[head ++] = null;
		
		if (tail-head < arr.length/4 && tail-head >= 2) {
			arr = ArrayUtils.downsize(arr, head, tail);
			
			tail = tail -head;
			head = 0;
		}
		
		return val;
	}
	
	public static void main(String[] args) {
		Queue<Integer> test = new QueueUsingArray<>();
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
		
		int i = 0;
		while(i < 20) {
			test.enqueue(++i);
		}
		
		i = 0;
		while(i < 20) {
			Assert.assertEquals((++i), test.dequeue().intValue());
		}
	}	
	
}
