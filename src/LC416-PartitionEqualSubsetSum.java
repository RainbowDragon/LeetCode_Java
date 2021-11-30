/*

LC416. Partition Equal Subset Sum

Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

Example 1:
Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].

Example 2:
Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.

Constraints:
1 <= nums.length <= 200
1 <= nums[i] <= 100

*/

class Solution {
    public boolean canPartition(int[] nums) {

        int sum = 0;
        for (int num : nums)
        {
            sum += num;
        }

        if (sum % 2 != 0) {
            return false;
        }

        int half = sum / 2;
        int n = nums.length;
        boolean[][] dp = new boolean[n+1][half+1];

        dp[0][0] = true;
        for (int i = 1; i <= n; i++)
        {
            int current = nums[i-1];
            for (int j = 0; j <= half; j++)
            {
                if (j < current) {
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-current];
                }
            }
        }

        return dp[n][half];
    }
}
