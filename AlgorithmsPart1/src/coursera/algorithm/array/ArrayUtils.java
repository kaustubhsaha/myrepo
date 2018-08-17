package coursera.algorithm.array;

public class ArrayUtils {

	public static <V> V[] upsize(V[] input) {
		int sz = input.length * 2;
		V[] output = (V[]) new Object[sz];
		for (int i=0; i<input.length; i++) {
			output[i] = input[i];
		}
		return output;
	}
	
	public static <V> V[] downsize(V[] input, int start, int end) {
		int sz = input.length / 2;
		V[] output = (V[]) new Object[sz];
		for (int i=start; i<=end; i++) {
			output[i-start] = input[i];
		}
		return output;
	}
}
