package old.dfs;

/**
 * @Author: sandro
 * @Create: 2019-09-07
 * @Description:
 **/
public class NumIsLands {
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int res = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    toZero(grid, i, j, rows, cols);
                }
            }
        }
        return res;
    }

    private void toZero(char[][] grid, int i, int j, int rows, int cols) {
        if (i < 0 || i >= rows || j < 0 || j >= cols) {
            return;
        }
        if (grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '0';
        toZero(grid, i + 1, j, rows, cols);
        toZero(grid, i - 1, j, rows, cols);
        toZero(grid, i, j + 1, rows, cols);
        toZero(grid, i, j - 1, rows, cols);
    }
}
