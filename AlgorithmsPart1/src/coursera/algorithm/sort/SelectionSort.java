package coursera.algorithm.sort;

import java.util.Arrays;

import org.junit.Assert;

import coursera.algorithm.shuffle.ShuffleUtils;

public class SelectionSort<V extends Comparable<V>> implements Sort<V> {

	@Override
	public void sort(V[] arr) {
		for (int i=0; i< arr.length; i++) {
			int j = findMinimum(arr, i);
			SortUtils.swap(arr, i, j);		
		}
	}

	protected int findMinimum(V[] arr, int start) {
		int min = start;
		for (int j=start; j<arr.length; j++) {
			if (SortUtils.isLess(arr, j, min)) {
				min = j;
			}
		}
		return min;
	}
	
	public static void main(String[] args) {
		Integer[] arr = new Integer[10];
		for (int i=0; i<10; i++) {
			arr[i] = i;
		}
		
		ShuffleUtils.shuffle(arr);
		System.out.println(Arrays.deepToString(arr));
		
		Sort<Integer> test = new SelectionSort<>();
		test.sort(arr);
		
		System.out.println(Arrays.deepToString(arr));
		
		Assert.assertTrue(SortUtils.isSorted(arr));
	}
}
