package coursera.algorithm.sort;

import java.util.Arrays;

import org.junit.Assert;

import coursera.algorithm.shuffle.ShuffleUtils;

public class ShellSort<V extends Comparable<V>> implements Sort<V> {

	@Override
	public void sort(V[] arr) {
		int h = findMaxSequence(arr);
		while (h >= 1) {
			for (int i=h; i< arr.length; i++) {
				for (int j =i; j>= h; j=j-h) {
					if (SortUtils.isLess(arr, j, j-h)) {
						SortUtils.swap(arr, j, j-h);
					}
					else {
						break;
					}
				}
			}
			
			h = h/3;
		}

	}
	
	protected int findMaxSequence(V[] arr) {
		int h = 1;
		while (h < arr.length) {
			h = 3*h + 1;
		}
		return h/3;
	}
	
	public static void main(String[] args) {
		Integer[] arr = new Integer[10];
		for (int i=0; i<10; i++) {
			arr[i] = i;
		}
		
		ShuffleUtils.shuffle(arr);
		System.out.println(Arrays.deepToString(arr));
		
		Sort<Integer> test = new ShellSort<>();
		test.sort(arr);
		
		System.out.println(Arrays.deepToString(arr));
		
		Assert.assertTrue(SortUtils.isSorted(arr));
	}

}
