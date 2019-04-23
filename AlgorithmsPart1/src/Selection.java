import java.util.Arrays;

import org.junit.Assert;

import coursera.algorithm.shuffle.ShuffleUtils;
import coursera.algorithm.sort.QuickSort;

public class Selection<V extends Comparable<V>> extends QuickSort<V> {

	public V select (V[] arr, int rank) {
		int lo = 0;
		int hi = arr.length - 1;
		
		while (lo <= hi) {
			int k = partition(arr, lo, hi);
			if (k == rank) {
				return arr[k];
			}
			else if (k < rank) {
				lo = k + 1;
			}
			else {
				hi = k - 1;
			}
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		Integer[] arr = new Integer[10];
		for (int i=0; i<10; i++) {
			arr[i] = i;
		}
		
		ShuffleUtils.shuffle(arr);
		System.out.println(Arrays.deepToString(arr));
		
		Selection<Integer> test = new Selection<>();
		for (int i=0; i<9; i++) {
			System.out.println(i);
			Assert.assertEquals(i, test.select(arr, i).intValue());
		}
	}
}
