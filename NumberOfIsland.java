public class NumberOfIsland {

    public static void main(String[] args) {
        char[][] ar = new char[][]{
                new char[]{'1', '1', '0', '0', '0'},
                new char[]{'1', '1', '0', '0', '0'},
                new char[]{'0', '0', '1', '0', '0'},
                new char[]{'0', '0', '0', '1', '1'}
        };
        System.out.println(new NumberOfIsland.Solution().numIslands(ar));
    }

    static class Solution {
        /*
        Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water),
        return the number of islands.
        An island is surrounded by water and is formed by connecting adjacent lands
        horizontally or vertically.
        You may assume all four edges of the grid are all surrounded by water.
         */
        public int numIslands(char[][] grid) {
            int count = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == '1') {
                        count++;
                        fillIslandWithWater(grid, i, j);
                    }
                }
            }
            return count;
        }

        private void fillIslandWithWater(char[][] grid, int i, int j) {
            if (i >= grid.length || i < 0 || j >= grid[i].length || j < 0 || grid[i][j] == '0') {
                return;
            }
            grid[i][j] = '0';
            fillIslandWithWater(grid, i + 1, j);
            fillIslandWithWater(grid, i - 1, j);
            fillIslandWithWater(grid, i, j + 1);
            fillIslandWithWater(grid, i, j - 1);
        }
    }
}
