package coursera.algorithm.sort;

import java.util.Arrays;

import org.junit.Assert;

import coursera.algorithm.shuffle.ShuffleUtils;

public class BottomUpMergeSort<V extends Comparable<V>> extends MergeSort<V> {

	@Override
	public void sort(V[] arr) {
		V[] aux = (V[]) new Comparable[arr.length];
		int n = arr.length;
		for (int sz = 1; sz < n; sz = sz * 2) {
			for (int i=0; i< n -sz; i = i + 2 * sz) {
				int lo = i;
				int hi = Math.min(i + 2*sz - 1, n -1);
				int mid = Math.min(i + sz - 1, n -1);
				merge(arr, aux, lo, mid, hi);
			}
		}
		
	}
	public static void main(String[] args) {
		Integer[] arr = new Integer[10];
		for (int i=0; i<10; i++) {
			arr[i] = i;
		}
		
		ShuffleUtils.shuffle(arr);
		System.out.println(Arrays.deepToString(arr));
		
		Sort<Integer> test = new BottomUpMergeSort<>();
		test.sort(arr);
		
		System.out.println(Arrays.deepToString(arr));
		
		Assert.assertTrue(SortUtils.isSorted(arr));
	}
}
