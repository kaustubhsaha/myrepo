package coursera.algorithm.sort;

import java.util.Arrays;

import org.junit.Assert;

import coursera.algorithm.shuffle.ShuffleUtils;

public class QuickSort<V extends Comparable<V>> implements Sort<V> {

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
		int j = partition(arr, lo, hi);
		quicksort(arr, lo, j-1);
		quicksort(arr, j+1, hi);
	}
	
	public int partition(V[] arr, int lo, int hi) {
		int i = lo;
		int j = hi + 1;
		
		while(true) {
			while (SortUtils.isLess(arr, ++i, lo)) {
				if (i == hi)
					break;
			}
			while (SortUtils.isLess(arr, lo, --j)) {
				if (j == lo)
					break;
			}
			if (i >= j)
				break;
			SortUtils.swap(arr, i, j);
		}
		SortUtils.swap(arr, lo, j);
		return j;
	}

	public static void main(String[] args) {
		Integer[] arr = new Integer[10];
		for (int i=0; i<10; i++) {
			arr[i] = i;
		}
		
		ShuffleUtils.shuffle(arr);
		System.out.println(Arrays.deepToString(arr));
		
		Sort<Integer> test = new QuickSort<>();
		test.sort(arr);
		
		System.out.println(Arrays.deepToString(arr));
		
		Assert.assertTrue(SortUtils.isSorted(arr));
	}
}
