/*

LC152. Maximum Product Subarray

Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.
It is guaranteed that the answer will fit in a 32-bit integer.
A subarray is a contiguous subsequence of the array.

Example 1:
Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

Example 2:
Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

Constraints:
1 <= nums.length <= 2 * 10^4
-10 <= nums[i] <= 10
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

*/

class Solution {
    public int maxProduct(int[] nums) {

        int result = nums[0];
        int imin = nums[0];
        int imax = nums[0];

        for (int i = 1; i < nums.length; i++)
        {
            if (nums[i] < 0) {
                int tmp = imin;
                imin = imax;
                imax = tmp;
            }

            imax = Math.max(nums[i], nums[i]*imax);
            imin = Math.min(nums[i], nums[i]*imin);

            result = Math.max(result, imax);
        }

        return result;
    }
}
