/*

LC886. Possible Bipartition

We want to split a group of n people (labeled from 1 to n) into two groups of any size. Each person may dislike some other people, and they should not go into the same group.
Given the integer n and the array dislikes where dislikes[i] = [ai, bi] indicates that the person labeled ai does not like the person labeled bi, return true if it is possible to split everyone into two groups in this way.

Example 1:
Input: n = 4, dislikes = [[1,2],[1,3],[2,4]]
Output: true
Explanation: group1 [1,4] and group2 [2,3].

Example 2:
Input: n = 3, dislikes = [[1,2],[1,3],[2,3]]
Output: false

Example 3:
Input: n = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
Output: false

Constraints:
1 <= n <= 2000
0 <= dislikes.length <= 104
dislikes[i].length == 2
1 <= dislikes[i][j] <= n
ai < bi
All the pairs of dislikes are unique.

*/

class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {

        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++)
        {
            graph[i] = new ArrayList<Integer>();
        }

        for (int[] edge : dislikes)
        {
            int i = edge[0] - 1;
            int j = edge[1] - 1;
            graph[i].add(j);
            graph[j].add(i);
        }

        int[] states = new int[n];

        for (int i = 0; i < n; i++)
        {
            if (states[i] == 0 && !isValid(graph, states, i, 1)) {
                return false;
            }
        }

        return true;
    }

    boolean isValid(ArrayList<Integer>[] graph, int[] states, int i, int state) {

        if (states[i] != 0) {
            return states[i] == state;
        }

        states[i] = state;

        for (int node : graph[i])
        {
            if (!isValid(graph, states, node, (-1)*state)) {
                return false;
            }
        }

        return true;
    }
}
