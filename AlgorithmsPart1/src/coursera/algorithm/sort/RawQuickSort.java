package coursera.algorithm.sort;

import java.util.Arrays;

import org.junit.Assert;

import coursera.algorithm.shuffle.ShuffleUtils;

public class RawQuickSort<V extends Comparable<V>> implements Sort<V> {

	@Override
	public void sort(V[] arr) {
		V pivot = null;
		
		V[] left, right = null;
		int nleft = 0, nright = 0;
		
		int i =0,j =0,k = 0;
		
		if (arr.length <= 1)
			return;
		
		
		pivot = arr[0];
		
		for(k=0; k< arr.length; k++) {
			if (SortUtils.isLess(arr[k], pivot)) {
				nleft ++;
			}
			else {
				nright ++;
			}
		}
		
		left = (V[]) new Comparable[nleft];
		right = (V[]) new Comparable[nright];
		
		
		for(k=0; k< arr.length; k++) {
			if (SortUtils.isLess(arr[k], pivot)) {
				left[i++] = arr[k];
			}
			else {
				right[j++] = arr[k];
			}
		}
		
		InsertionSort sort = new InsertionSort<>();
		sort.sort(left);
		sort.sort(right);
		
		k = 0;
		for (i =0; i< nleft; i++) {
			arr[k++] = left[i];
		}
		for (j =0; j< nright; j++) {
			arr[k++] = right[j];
		}
	}

	public static void main(String[] args) {
		Integer[] arr = new Integer[10];
		for (int i=0; i<10; i++) {
			arr[i] = i;
		}
		
		ShuffleUtils.shuffle(arr);
		System.out.println(Arrays.deepToString(arr));
		
		Sort<Integer> test = new RawQuickSort<>();
		test.sort(arr);
		
		System.out.println(Arrays.deepToString(arr));
		
		Assert.assertTrue(SortUtils.isSorted(arr));
	}

}
