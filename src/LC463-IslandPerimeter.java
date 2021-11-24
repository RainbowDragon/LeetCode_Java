/*

LC463. Island Perimeter

You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.
Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).
The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island. One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

Example 1:
Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
Output: 16
Explanation: The perimeter is the 16 yellow stripes in the image above.

Example 2:
Input: grid = [[1]]
Output: 4

Example 3:
Input: grid = [[1,0]]
Output: 4

Constraints:
row == grid.length
col == grid[i].length
1 <= row, col <= 100
grid[i][j] is 0 or 1.
There is exactly one island in grid.

*/

class Solution {
    public int islandPerimeter(int[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;

        result = 0;

        for (int i = 0; i < nr; i++)
            for (int j = 0; j < nc; j++)
            {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, nr, nc);
                    break;
                }
            }

        return result;
    }

    static int result;

    void dfs(int[][] grid, int i, int j, int nr, int nc) {

        if (i < 0 || i >= nr || j < 0 || j >= nc || grid[i][j] != 1) {
            return;
        }

        grid[i][j] = 2;

        if (i == 0 || grid[i-1][j] == 0) {
            result++;
        }

        if (i == nr - 1 || grid[i+1][j] == 0) {
            result++;
        }

        if (j == 0 || grid[i][j-1] == 0) {
            result++;
        }

        if (j == nc - 1 || grid[i][j+1] == 0) {
            result++;
        }

        dfs(grid, i-1, j, nr, nc);
        dfs(grid, i+1, j, nr, nc);
        dfs(grid, i, j-1, nr, nc);
        dfs(grid, i, j+1, nr, nc);
    }
}
