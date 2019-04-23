package coursera.algorithm.shuffle;

import java.util.Random;

import coursera.algorithm.sort.SortUtils;

public class ShuffleUtils {

	public static <V> void shuffle(V[] arr) {
		Random random = new Random();
		for (int i=1; i< arr.length; i++) {
			int j = random.nextInt(i);
			SortUtils.swap(arr, i, j);
		}
	}
}
