package com.hemanth;

/**
 * Given an array of integers, find the first missing positive integer in linear time and constant space.
 * In other words, find the lowest positive integer that does not exist in the array.
 * The array can contain duplicates and negative numbers as well.
 * For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.
 * You can modify the input array in-place.
 * <br>
 * Leetcode link <a href="https://leetcode.com/problems/first-missing-positive/">First Missing Positive</a>
 */
public class FirstMissingPositiveNumber {
    public static void main(String[] args) {
        int[] arr1 = new int[]{3, 4, -1, 1};
        int[] arr2 = new int[]{1, 2, 0};

        System.out.println(firstMissingPositive(arr1));
        System.out.println(firstMissingPositive(arr2));
    }

    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Set negative numbers to a number outside the range of the problem (greater than length)
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }

        // Use index marking to record the presence of numbers
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }

        // The first index which has a positive number indicates the missing positive number
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        return n + 1;
    }

}
