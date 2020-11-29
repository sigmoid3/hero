package finger2offer.search;

public class SearchMatrix {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
        int target = 5;
        System.out.println(sol.searchMatrix1(matrix, target));
    }

    static class Solution {
        //若涉及是使用一维数组，可以把[row][col]改成[row*col+col]
        public boolean searchMatrix1(int[][] matrix, int target) {
            if (matrix.length == 0 || matrix == null || matrix[0].length == 0) {
                return false;
            }
            int col_len = matrix[0].length, row_len = matrix.length;
            int idx_r = 0, idx_c = col_len - 1;
            while (idx_r < row_len && idx_c >= 0) {
                if (target == matrix[idx_r][idx_c]) {
                    return true;
                } else {
                    if (target < matrix[idx_r][idx_c]) {
                        idx_c--;
                    } else {
                        idx_r++;
                    }
                }
            }
            return false;
        }

        public boolean searchMatrix2(int[][] matrix, int target) {
            if (matrix.length == 0)
                return false;
            int len_row = matrix.length;
            int len_col = matrix[0].length;
            int low = 0, high = len_row * len_col;
            while (low < high) {
                int mid = (low + high) / 2;
                if (matrix[mid / len_col][mid % len_col] == target) {
                    return true;
                } else if (matrix[mid / len_col][mid % len_col] < target) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return false;
        }
    }
}
