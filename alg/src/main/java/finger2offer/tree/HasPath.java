package finger2offer.tree;

import java.util.Arrays;

public class HasPath {
    public static void main(String[] args) {
        char[] matrix = {'a', 'b', 'c', 'e', 's', 'f', 'c', 's', 'a', 'd', 'e', 'e'};
        char[] str = {'a', 'b', 'c', 'c', 'e', 'd'};
        boolean ret = hasPath(matrix, 3, 4, str);
        System.out.println(ret);
    }

    private static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix.length == 0 || rows < 1 || cols < 1 || str.length == 0) {
            return false;
        }
        boolean[] visited = new boolean[rows * cols];
        Arrays.fill(visited, false);
        //length of the current array
        int pathLength = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (hasAdjust(matrix, rows, cols, i, j, str, visited, pathLength)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean hasAdjust(char[] matrix, int rows, int cols, int row, int col, char[] str, boolean[] visited, int pathLength) {
        if (pathLength == str.length) {
            return true;
        }
        boolean hasPath = false;
        //control the boundary of the matrix
        if (row >= 0 && row < rows && col >= 0 && col < cols && matrix[row * cols + col] == str[pathLength] && !visited[row * cols + col]) {
            ++pathLength;
            visited[row * cols + col] = true;
            //move to up,down,right,left
            hasPath = hasAdjust(matrix, rows, cols, row + 1, col, str, visited, pathLength) ||
                    hasAdjust(matrix, rows, cols, row - 1, col, str, visited, pathLength) ||
                    hasAdjust(matrix, rows, cols, row, col + 1, str, visited, pathLength) ||
                    hasAdjust(matrix, rows, cols, row, col - 1, str, visited, pathLength);
            //bachtracking
            if (!hasPath) {
                --pathLength;
                visited[row * cols + col] = false;
            }
        }
        return hasPath;
    }
}