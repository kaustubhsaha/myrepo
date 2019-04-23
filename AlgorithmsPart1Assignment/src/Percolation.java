import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

	private final int size;
	private final int width;
	private final int[] open;
	private final WeightedQuickUnionUF uf;

	// create N-by-N grid, with all sites blocked
	public Percolation(final int n) {
		size = n * n;
		width = n;
		open = new int[size];
		uf = new WeightedQuickUnionUF(size + 2);
	}

	private void validate(final int i, final int j) {
		if (i <= 0 || i > width) {
			throw new java.lang.IllegalArgumentException("row index i out of bounds");
		}
		if (j <= 0 || j > width) {
			throw new java.lang.IllegalArgumentException("row index i out of bounds");
		}
	}

	private int convertToOneDimension(final int row, final int col) {
		return (row - 1) * width + col - 1;
	}

	public void open(final int row, final int col) {
		validate(row, col);
		final int num = convertToOneDimension(row, col);
		open[num] = 1;
		connectToOpenNeighbors(row, col);
	}

	private void tryUnion(final int row, final int col, final int index) {
		if (isOpen(row, col)) {
			final int num = convertToOneDimension(row, col);
			uf.union(num, index);
		}
	}

	public boolean isOpen(final int row, final int col) {
		validate(row, col);
		final int num = convertToOneDimension(row, col);
		return open[num] == 1;

	}

	private void connectToOpenNeighbors(final int row, final int col) {
		final int num = convertToOneDimension(row, col);
		if (col < width) {
			tryUnion(row, col + 1, num);
		}
		if (col > 1) {
			tryUnion(row, col - 1, num);
		}

		if (row < width) {
			tryUnion(row + 1, col, num);
		} else {
			uf.union(num, size + 1);
		}
		if (row > 1) {
			tryUnion(row - 1, col, num);
		} else {
			uf.union(num, size);
		}
	}

	public boolean isFull(final int row, final int col) {
		validate(row, col);
		final int num = convertToOneDimension(row, col);
		return uf.connected(size, num);
	}

	public int numberOfOpenSites() {
		int count = 0;
		for (final int element : open) {
			if (element == 1) {
				count++;
			}
		}
		return count;
	}

	public boolean percolates() {
		return uf.connected(size, size + 1);
	}

	public static void main(final String[] args) {
		final Percolation perc = new Percolation(3);
		perc.open(1, 2);
		perc.open(2, 2);
		perc.open(2, 3);
		perc.open(3, 3);
		final boolean c = perc.isFull(1, 1);
		StdOut.println(c);
	}
}
