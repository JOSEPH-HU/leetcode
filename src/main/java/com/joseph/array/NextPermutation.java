package com.joseph.array;

/**
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 */

public class NextPermutation {

    public static void nextPermutation(int[] nums) {

        int end = nums.length-2;

        while(end>=0 && nums[end+1]<=nums[end]){
            end--;
        }

        if (end>=0){
            int j = nums.length-1;
            while (j>=0 && nums[j]<=nums[end]){
                j--;
            }
            swap(nums,end,j);
        }
        reverse(nums,end+1);

    }


    private static void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1,5,1};
        nextPermutation(nums);

        for (int i=0;i<nums.length;i++){
            System.out.println(nums[i]);
        }
    }

}
