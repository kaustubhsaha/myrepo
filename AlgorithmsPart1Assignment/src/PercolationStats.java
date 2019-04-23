import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

	private final double[] thresholds;
	private final int experiments;
	private final int size;

	// perform T independent computational experiments on an N-by-N grid
	public PercolationStats(final int n, final int trials) {
		if (n <= 0 || trials <= 0) {
			throw new IllegalArgumentException("input params cant be 0 or negative");
		}

		size = n;
		experiments = trials;
		thresholds = new double[experiments];

		for (int i = 0; i < trials; i++) {
			thresholds[i] = findPercolationThreshold();
		}
	}

	// sample mean of percolation threshold
	public double mean() {
		return StdStats.mean(thresholds);
	}

	// sample standard deviation of percolation threshold
	public double stddev() {
		if (experiments == 1) {
			return Double.NaN;
		}
		return StdStats.stddev(thresholds);
	}

	// returns lower bound of the 95% confidence interval
	public double confidenceLo() {
		return mean() - 1.96 * stddev() / Math.sqrt(experiments);
	}

	// returns upper bound of the 95% confidence interval
	public double confidenceHi() {
		return mean() + 1.96 * stddev() / Math.sqrt(experiments);
	}

	private double findPercolationThreshold() {
		final Percolation perc = new Percolation(size);
		int i, j;
		int count = 0;
		while (!perc.percolates()) {
			do {
				i = StdRandom.uniform(size) + 1;
				j = StdRandom.uniform(size) + 1;
			} while (perc.isOpen(i, j));
			count++;
			perc.open(i, j);
		}
		return count / Math.pow(size, 2);
	}

	// test client, described below
	public static void main(final String[] args) {
		final int n = Integer.parseInt(args[0]);
		final int t = Integer.parseInt(args[1]);
		final PercolationStats stats = new PercolationStats(n, t);
		StdOut.printf("mean = %f\n", stats.mean());
		StdOut.printf("stddev = %f\n", stats.stddev());
		StdOut.printf("95%% confidence interval = %f, %f\n", stats.confidenceLo(), stats.confidenceHi());
	}
}
