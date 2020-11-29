package finger2offer.arr;

import java.util.ArrayList;

public class PrintMatrix {
	public static void main(String[] args) {
		int[][] matrix = new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}, {9, 10}};
		System.out.println(printMatrix(matrix, matrix[0].length, matrix.length));
	}

	public ArrayList<Integer> printMatrix(int[][] matrix) {
		ArrayList<Integer> ret = new ArrayList<>();
		int r1 = 0, r2 = matrix.length - 1, c1 = 0, c2 = matrix[0].length - 1;
		while (r1 <= r2 && c1 <= c2) {
			for (int i = c1; i <= c2; i++)
				ret.add(matrix[r1][i]);
			for (int i = r1 + 1; i <= r2; i++)
				ret.add(matrix[i][c2]);
			if (r1 != r2)
				for (int i = c2 - 1; i >= c1; i--)
					ret.add(matrix[r2][i]);
			if (c1 != c2)
				for (int i = r2 - 1; i > r1; i--)
					ret.add(matrix[i][c1]);
			r1++;
			r2--;
			c1++;
			c2--;
		}
		return ret;
	}

	public static ArrayList<Integer> printMatrix(int[][] matrix, int columns, int rows) {
		if (matrix == null || columns <= 0 || rows <= 0) {
			return null;
		}
		int start = 0;
		ArrayList<Integer> ret = new ArrayList<>();
		if (matrix[0].length == 1) {
			for (int i = 0; i < matrix.length; i++) {
				ret.add(matrix[i][0]);
			}
			return ret;
		}
		while (columns > start * 2 && rows > start * 2) {
			printInCircle(ret, matrix, columns, rows, start);
			++start;
		}
		return ret;
	}

	public static void printInCircle(ArrayList<Integer> ret, int[][] matrix, int columns, int rows, int start) {
		int endRow = rows - 1 - start;
		int endCol = columns - 1 - start;
		for (int i = start; i <= endCol; i++) {
			ret.add(matrix[start][i]);
		}
		if (start < endRow) {
			for (int i = start + 1; i <= endRow; i++) {
				ret.add(matrix[i][endRow]);
			}
		}
		if (start < endCol && start < endRow) {
			for (int i = endCol - 1; i >= start; i--) {
				ret.add(matrix[endRow][i]);
			}
		}
		if (start < endCol && start < endRow - 1) {
			for (int i = endRow - 1; i >= start + 1; i--) {
				ret.add(matrix[i][start]);
			}
		}
	}
}
