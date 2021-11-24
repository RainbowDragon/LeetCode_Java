/*

LC200. Number of Islands

Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:
Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1

Example 2:
Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3

Constraints:
m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.

*/

class Solution {
    public int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;

        int result = 0;

        for (int i = 0; i < nr; i++)
            for (int j = 0; j < nc; j++)
            {
                if (grid[i][j] == '1') {
                    result++;
                    dfs(grid, i, j, nr, nc);
                }
            }

        return result;
    }

    void dfs(char[][] grid, int i, int j, int nr, int nc) {

        if (i < 0 || i >= nr || j < 0 || j >= nc || grid[i][j] != '1') {
            return;
        }

        grid[i][j] = '#';

        dfs(grid, i-1, j, nr, nc);
        dfs(grid, i+1, j, nr, nc);
        dfs(grid, i, j-1, nr, nc);
        dfs(grid, i, j+1, nr, nc);
    }
}
