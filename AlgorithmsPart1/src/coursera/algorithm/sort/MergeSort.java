package coursera.algorithm.sort;

import java.util.Arrays;

import org.junit.Assert;

import coursera.algorithm.shuffle.ShuffleUtils;

public class MergeSort<V extends Comparable<V>> implements Sort<V> {

	@Override
	public void sort(V[] arr) {
		V[] aux = (V[]) new Comparable[arr.length];
		int lo = 0;
		int hi = arr.length -1;
		mergesort(arr, aux, lo, hi);
		
	}
	
	protected void mergesort(V[] arr, V[] aux, int lo, int hi) {
		if (lo >= hi)
			return;
		int mid = lo + (hi - lo)/2;
		mergesort(arr, aux, lo, mid);
		mergesort(arr, aux, mid+1, hi);
		merge(arr, aux, lo, mid, hi);
	}
	
	protected void merge(V[] arr, V[] aux, int lo, int mid, int hi) {		
		int i = lo;
		int j = mid + 1;
		int k = lo;
		
		for (k=lo; k<= hi; k++) {
			aux[k] = arr[k];
		}
		
		for(k = lo; k<=hi; k++) {
			if (i > mid) {
				arr[k] = aux[j++];
				
			}
			else if (j > hi) {
				arr[k] = aux[i++];			
			}
			else {
				if (SortUtils.isLess(aux, i, j)) {
					arr[k] = aux[i++];
				} else {
					arr[k] = aux[j++];
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
		
		Sort<Integer> test = new MergeSort<>();
		test.sort(arr);
		
		System.out.println(Arrays.deepToString(arr));
		
		Assert.assertTrue(SortUtils.isSorted(arr));
	}

}
