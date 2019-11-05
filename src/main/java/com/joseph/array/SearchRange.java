package com.joseph.array;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 */

public class SearchRange {

    public static int[] searchRange(int[] nums, int target) {

        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;

       if (nums == null || nums.length<=0){
           return res;
       }

       if (nums.length==1){
           if (nums[0] == target ){
               res[0] = 0;
               res[1] = 0;
               return res;
           }else {
               return res;
           }
       }

       int mid = bSearch(nums, target);

        System.out.println("==" + mid);

       if (mid == -1){
           return res;
       }

       int low = mid ;
       int high  = mid;

       while (high<nums.length-1 && nums[high+1]==target){
           high++;
       }

       while (low>0 && nums[low-1]==target){
           low--;
       }
       res[0] = low;
       res[1] = high;

        return res;

    }


    public static int bSearch(int[] nums, int target){
        int low = 0;
        int high = nums.length-1;

        int mid = (low+high)/2;

        while (low<=high){
            if (target == nums[mid]){
                return mid;
            }else if(nums[mid]>target){
                high = mid-1 ;
            }else {
                low = mid+1;
            }
            mid = (low+high)/2;
        }

        return -1;
    }

    public static void main(String[] args) {
        int [] nums = {5,7,7,8,8,10};

        //int[] nums = {2,2};
        int[] result = searchRange(nums,2);
        for (int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }

        //int[] nums2 = {5,7,7,8,8,10};
       // System.out.println(searchRange(nums2,6).toString());
    }
}
