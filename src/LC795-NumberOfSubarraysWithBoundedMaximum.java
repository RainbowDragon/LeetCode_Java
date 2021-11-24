/*

LC795. Number of Subarrays with Bounded Maximum

Given an integer array nums and two integers left and right, return the number of contiguous non-empty subarrays such that the value of the maximum array element in that subarray is in the range [left, right].
The test cases are generated so that the answer will fit in a 32-bit integer.

Example 1:
Input: nums = [2,1,4,3], left = 2, right = 3
Output: 3
Explanation: There are three subarrays that meet the requirements: [2], [2, 1], [3].

Example 2:
Input: nums = [2,9,2,5,6], left = 2, right = 8
Output: 7

Constraints:
1 <= nums.length <= 10^5
0 <= nums[i] <= 10^9
0 <= left <= right <= 10^9

*/

class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {

        return count(nums, right) - count(nums, left-1);
    }

    int count(int[] nums, int bound) {

        int result = 0;
        int current = 0;

        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] <= bound) {
                current++;
            }
            else {
                current = 0;
            }

            result += current;
        }

        return result;
    }
}
