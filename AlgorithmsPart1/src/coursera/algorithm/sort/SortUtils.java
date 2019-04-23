package coursera.algorithm.sort;

public class SortUtils {

	public static <V> void swap(V[] arr, int i, int j) {
		V val = arr[i];
		arr[i] = arr[j];
		arr[j] = val;
	}
	
	public static <V extends Comparable<V>> boolean isLess(V val1, V val2) {
		return val1.compareTo(val2) < 0;
	}
	
	public static <V extends Comparable<V>> boolean isLess (V[] arr, int i , int j){
		return arr[i].compareTo(arr[j]) < 0;
	}
	
	public static <V extends Comparable<V>> boolean isSorted (V[] arr) {
		for (int i=1; i< arr.length; i++) {
			if (isLess(arr, i, i-1)) {
				return false;
			}
		}
		return true;
	}
}
