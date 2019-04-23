package coursera.algorithm.priorityqueue;

import java.util.Arrays;

import org.junit.Assert;

import coursera.algorithm.array.ArrayUtils;
import coursera.algorithm.queue.Queue;
import coursera.algorithm.queue.QueueUsingArray;
import coursera.algorithm.sort.SortUtils;

public class PriorityQueue<V extends Comparable<V>> implements Queue<V> {

	protected V[] arr;
	protected int index;
	
	public PriorityQueue() {
		arr = (V[])new Comparable[16];
	}
	
	private int left(int i) {
		return 2*i;
	}
	
	private int right(int i) {
		return 2*i + 1;
	}
	
	private int parent(int i) {
		return i/2;
	}
	
	private boolean isRoot(int i) {
		return (i==1);
	}
	
	private boolean isLeaf(int i) {
		int l = left(i);
		int r = right(i);
		boolean leftExists = exists(l);
		boolean rightExists = exists(r);
		boolean atLeastOneChild = leftExists || rightExists;
		return !atLeastOneChild; 
				
		
		//return (!(exists(left(i)))||exists(right(i)));
	}
	
	private boolean exists(int i) {
		return (i<arr.length && arr[i] != null);
	}
	
	protected boolean hasChild(int i) {
		return !isLeaf(i);
	}
	
	protected boolean hasBiggerChild(int i) {
		
		boolean hasBiggerLeft = exists(left(i)) && SortUtils.isLess(arr, i, left(i));
		boolean hasBiggerRight = exists(right(i)) && SortUtils.isLess(arr, i, right(i));
		
		return hasBiggerLeft || hasBiggerRight;
	}
	
	protected boolean hasSmallerParent(int i) {
		return SortUtils.isLess(arr, parent(i), i);
	}
	
	protected int findLargerChild(int i) {
		V left = exists(left(i)) ? arr[left(i)] : null;
		V right = exists(right(i)) ? arr[right(i)] : null;
		if (left == null) {
			return right(i);
		}
		else if (right == null) {
			return left(i);
		}
		else {
			return left.compareTo(right)>0 ? left(i):right(i);
		}
	}
	
	
	protected void sink(int i) {
		while(hasChild(i) && hasBiggerChild(i)) {
			int j = findLargerChild(i);
			SortUtils.swap(arr, i, j);
			i = j;
		}
	}
	
	protected void swim(int i) {
		while (!isRoot(i) && hasSmallerParent(i)) {
			int j = parent(i);
			SortUtils.swap(arr, i, j);
			i = j;
		}
	}
	
	@Override
	public void enqueue(V val) {
		if (index == arr.length-1) {
			arr = ArrayUtils.upsize(arr);
		}
		arr[++index] = val;
		swim(index);
	}

	@Override
	public V dequeue() {
		V val = arr[1];
		SortUtils.swap(arr, 1, index);
		arr[index --] = null;
		sink(1);
		return val;
	}
	
	public static void main(String[] args) {
		Queue<Integer> test = new PriorityQueue<>();
		test.enqueue(1);
		test.enqueue(2);
		test.enqueue(3);
		
		Assert.assertEquals(3, test.dequeue().intValue());
		test.enqueue(4);
		test.enqueue(5);
		
		Assert.assertEquals(5, test.dequeue().intValue());
		Assert.assertEquals(4, test.dequeue().intValue());
		Assert.assertEquals(2, test.dequeue().intValue());
		Assert.assertEquals(1, test.dequeue().intValue());
		
		int i = 0;
		while(i < 20) {
			test.enqueue(++i);
		}
		
		i = 0;
		while(i < 20) {
			Assert.assertEquals(20 - (i++), test.dequeue().intValue());
		}
	}	

}
