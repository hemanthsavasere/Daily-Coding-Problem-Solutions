package com.hemanth;

import java.util.Arrays;

/**
 * Given an array of integers, return a new array such that each element at index i of the new array is the product
 * of all the numbers in the original array except the one at index i.
 * For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24].
 * If our input was [3, 2, 1], the expected output would be [2, 3, 6].
 * Follow-up: what if you can't use division?
 * <p/>
 * Leetcode Link : <a href="https://leetcode.com/problems/product-of-array-except-self/">Product of Array Except Self</a>
 */

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(productExceptSelf(nums)));

        nums = new int[]{1, 2, 3, 4, 0, 5};
        System.out.println(Arrays.toString(productExceptSelf(nums)));

        nums = new int[]{1, 2, 3, 4, 5, 6, 0, 0, 9, 10};
        System.out.println(Arrays.toString(productExceptSelf(nums)));

    }

    public static int[] productExceptSelf(int[] nums) {
        int product = 1;
        int cntZeros = 0;

        for (int num : nums) {
            if (cntZeros >= 2) {
                break;
            } else if (num == 0) {
                cntZeros += 1;
            } else {
                product *= num;
            }
        }

        if (cntZeros >= 2) {
            Arrays.fill(nums, 0);
        } else if (cntZeros == 1) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    nums[i] = product;
                } else {
                    nums[i] = 0;
                }
            }
        } else{
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    nums[i] = product / nums[i];
                }
            }
        }
        return nums;
    }
}
