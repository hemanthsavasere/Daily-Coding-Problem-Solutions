package com.hemanth;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Given a list of numbers, return whether any two sums to k.
 * For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
 * Bonus: Can you do this in one pass?
 * <p>
 * Leetcode link : <a href="https://leetcode.com/problems/two-sum/">Two Sum</a>
 * <br>
 * Other Variation
 * <br>
 * Leetcode link : <a href="https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/">Two Sum II - Input Array Is Sorted</a>
 * <br>
 *
 */

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = new int[]{10, 15, 3, 7};
        int target = 17;
        System.out.println(Arrays.toString(twoSum(arr, target)));
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                return new int[]{num, map.get(num)};
            } else {
                map.put(target - num, num);
            }
        }
        return new int[]{-1, -1};
    }
}
