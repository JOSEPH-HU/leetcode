package com.joseph.array;

import java.util.*;

/**
 * Created by hlw on 19-6-3.
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *  给定 nums = [2, 7, 11, 15], target = 9
 *  因为 nums[0] + nums[1] = 2 + 7 = 9
 *  所以返回 [0, 1]
 */
public class TwoSum {

    public static void main(String[] args){

        int []arr = {2, 7, 11, 15};
        int target = 9;
        int [] result = twoSum1(arr, target);
        if (result !=null){
            for (int num : result){
                System.out.println(num);
            }
        }

    }


    public static int[] twoSum(int[] nums, int target) {

        if (nums == null || nums.length==0){
            return null;
        }

        int[] arr = new int[2];

        for (int i=0;i<nums.length;i++){

            for (int j=i+1;j<nums.length;j++){
                if (nums[i] + nums[j] == target){
                    arr[0] = i;
                    arr[1] = j;
                }
            }
        }


        return arr;

    }


    public static int[] twoSum1(int[] nums, int target) {

        if (nums == null || nums.length==0){
            return null;
        }

        int[] arr = new int[2];
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();

        for (int i=0;i<nums.length;i++){

            if (map.containsKey(target - nums[i])){
                arr[0] = map.get(target-nums[i]);
                arr[1] = i;
            }else{
                map.put(nums[i],i);
            }
        }


        return arr;

    }
}
