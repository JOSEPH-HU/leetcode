package com.joseph.array;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class MaxSubArray {
    public static int maxSubArray(int[] nums) {
        int result = nums[0];
        int sum = nums[0];

        for (int i=1;i<nums.length;i++){
            if (sum>=0){
                sum += nums[i];
            }else {
                sum = nums[i];
            }

            result = Math.max(sum,result);

        }

        return result;

    }

    public static void main(String[] args) {
        int [] nums = {-2,1,-3,4,-1,2,1,-5,4};
        //int [] nums = {1,2};
        System.out.println(maxSubArray(nums));
    }
}
