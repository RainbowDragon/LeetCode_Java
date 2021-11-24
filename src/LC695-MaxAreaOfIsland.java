/*

LC695. Max Area of Island

You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
The area of an island is the number of cells with a value 1 in the island.
Return the maximum area of an island in grid. If there is no island, return 0.

Example 1:
Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
Output: 6
Explanation: The answer is not 11, because the island must be connected 4-directionally.

Example 2:
Input: grid = [[0,0,0,0,0,0,0,0]]
Output: 0

Constraints:
m == grid.length
n == grid[i].length
1 <= m, n <= 50
grid[i][j] is either 0 or 1.

*/

class Solution {
    public int maxAreaOfIsland(int[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;

        int result = 0;

        for (int i = 0; i < nr; i++)
            for (int j = 0; j < nc; j++)
            {
                if (grid[i][j] == 1) {
                    current = 0;
                    dfs(grid, i, j, nr, nc);
                    result = Math.max(result, current);
                }
            }

        return result;
    }

    static int current;

    void dfs(int[][] grid, int i, int j, int nr, int nc) {

        if (i < 0 || i >= nr || j < 0 || j >= nc || grid[i][j] != 1) {
            return;
        }

        grid[i][j] = 2;
        current++;

        dfs(grid, i-1, j, nr, nc);
        dfs(grid, i+1, j, nr, nc);
        dfs(grid, i, j-1, nr, nc);
        dfs(grid, i, j+1, nr, nc);
    }
}