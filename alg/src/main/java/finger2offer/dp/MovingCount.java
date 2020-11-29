package finger2offer.dp;

import java.util.Arrays;

public class MovingCount {

    public static void main(String[] args) {
        int ret = movingCount(18, 38, 38);
        System.out.println(ret);
    }

    private static int movingCount(int threshold, int rows, int cols) {
        if (threshold < 0 || rows < 1 || cols < 1) {
            return 0;
        }
        boolean[] visited = new boolean[rows * cols];
        Arrays.fill(visited, false);
        int count = move(threshold, rows, cols, 0, 0, visited);
        return count;
    }

    private static int move(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
        int count = 0;
        if (check(threshold, rows, cols, row, col, visited)) {
            visited[row * cols + col] = true;
            count = 1 + move(threshold, rows, cols, row + 1, col, visited) +
                    move(threshold, rows, cols, row - 1, col, visited) +
                    move(threshold, rows, cols, row, col + 1, visited) +
                    move(threshold, rows, cols, row, col - 1, visited);
        }
        return count;
    }

    private static boolean check(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
        return row >= 0 && row < rows && col >= 0 && col < cols && getSum(row) + getSum(col) <= threshold && !visited[row * cols + col];
    }

    private static int getSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}