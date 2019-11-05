package com.joseph.array;

/**
 * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 * 输入: [1,2,0]
 * 输出: 3
 *
 * 输入: [3,4,-1,1]
 * 输出: 2
 */
public class FirstMissingPositive {
    public static int firstMissingPositive(int[] nums) {
        if (nums==null){
            return 1;
        }

        for (int i=0;i<nums.length;){
            if(nums[i]> 0 &&nums[i]<nums.length&&nums[i]!=nums[nums[i]-1]){
                int index = nums[i];
                nums[i] = nums[index-1];
                nums[index-1] = index;
            }else {
                i++;
            }
        }

        for (int j=0;j<nums.length;j++){
            if (nums[j]!=j+1){
                return j+1;
            }
        }

        return nums.length +1;

    }

    public static void main(String[] args) {
        //int[] nums = {7,8,9,11,12};

        //int[] nums = {2,1};
        // int[] nums = {1,2,0};

       int [] nums = {3,4,-1,1};
       // int [] nums = {3,4,1,-1};
        System.out.println(firstMissingPositive(nums));

    }
}
