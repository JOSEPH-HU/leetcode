package com.joseph.array;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 */
public class SearchInsert {

    public static int searchInsert(int[] nums, int target) {

        if (nums.length == 1){
            if (nums[0] == target || nums[0]>target){
                return 0;
            }else{
                return 1;
            }
        }
        int left = 0 ;
        int right = nums.length;
        while (left < right) {
            int mid =(left + right) /2;
            if (nums[mid] > target || nums[mid] == target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;

    }

    public static void main(String[] args) {
        int [] nums = {1,3,5,6};
        System.out.println(searchInsert(nums,5));
        System.out.println(searchInsert(nums,2));
        System.out.println(searchInsert(nums,7));
        System.out.println(searchInsert(nums,0));


    }

}
