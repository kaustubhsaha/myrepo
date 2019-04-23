package coursera.algorithm.sort;

import java.util.Arrays;

import org.junit.Assert;

import coursera.algorithm.shuffle.ShuffleUtils;

public class ThreeWayQuickSort<V extends Comparable<V>> extends QuickSort<V> {

	@Override
	public void sort(V[] arr) {
		ShuffleUtils.shuffle(arr);
		int lo = 0;
		int hi = arr.length -1;
		quicksort(arr, lo, hi);
	}
	
	public void quicksort(V[] arr, int lo, int hi) {
		
		if (lo >= hi)
			return;
		
		int lt = lo;
		int gt = hi;
		
		int i = lo;
		
		V pivot = arr[lo];
		
		while (i <= gt) {
			int cmp = arr[i].compareTo(pivot);
			if (cmp == 0) {
				i++;
			}
			else if (cmp < 0) {
				SortUtils.swap(arr, i++, lt++);
			}
			else {
				SortUtils.swap(arr, i, gt--);
			}
		}
		
		quicksort(arr, lo, lt - 1);
		quicksort(arr, gt + 1, hi);
	}
	
	public static void main(String[] args) {
		Integer[] arr = new Integer[10];
		for (int i=0; i<10; i++) {
			arr[i] = i;
		}
		
		ShuffleUtils.shuffle(arr);
		System.out.println(Arrays.deepToString(arr));
		
		Sort<Integer> test = new ThreeWayQuickSort<>();
		test.sort(arr);
		
		System.out.println(Arrays.deepToString(arr));
		
		Assert.assertTrue(SortUtils.isSorted(arr));
	}
}
