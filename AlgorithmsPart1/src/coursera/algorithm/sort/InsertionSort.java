package coursera.algorithm.sort;

import java.util.Arrays;

import org.junit.Assert;

import coursera.algorithm.shuffle.ShuffleUtils;

public class InsertionSort<V extends Comparable<V>> implements Sort<V> {

	@Override
	public void sort(V[] arr) {
		for (int i=0; i< arr.length; i++) {
			for (int j=i; j>0; j--) {
				if (SortUtils.isLess(arr, j, j-1)) {
					SortUtils.swap(arr, j, j-1);
				}
				else {
					break;
				}
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
		
		Sort<Integer> test = new InsertionSort<>();
		test.sort(arr);
		
		System.out.println(Arrays.deepToString(arr));
		
		Assert.assertTrue(SortUtils.isSorted(arr));
	}

}
