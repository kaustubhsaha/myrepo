package coursera.algorithm.stackqueue.variants;

import org.junit.Assert;

import coursera.algorithm.queue.Queue;
import coursera.algorithm.queue.QueueUsingArray;
import coursera.algorithm.stack.Stack;
import coursera.algorithm.stack.StackUsingArray;

public class QueueWithStacks<V> implements Queue<V> {
	
	Stack<V> s1;
	Stack<V> s2;
	
	QueueWithStacks(){
		this.s1 = new StackUsingArray<>();
		this.s2 = new StackUsingArray<>();
	}

	@Override
	public void enqueue(V val) {
		s1.push(val);
	}

	@Override
	public V dequeue() {
		if (s2.isEmpty()) {
			while(!s1.isEmpty()) {
				s2.push(s1.pop());
			}
		}
		return s2.pop();
	}

	public static void main(String[] args) {
		
		Queue<Integer> test = new QueueWithStacks<>();
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
