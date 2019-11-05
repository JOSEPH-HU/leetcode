package com.joseph.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：
 *
 * 答案中不可以包含重复的四元组。
 */

public class FourSum {

    public static List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> resultList = new ArrayList<List<Integer>>();

        Arrays.sort(nums);

        for (int i=0;i<nums.length;i++){
            if (i>0 && nums[i]==nums[i-1]){
                continue;
            }

            for (int j=i+1;j<nums.length;j++){
                if (j-i>1 && nums[j] == nums[j-1]){//这儿j-i>1非常重要
                    continue;
                }
                int left = j+1;
                int right = nums.length - 1;
                while (left<right){
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target){
                        List<Integer> tmpList = new ArrayList<Integer>();
                        tmpList.add(nums[i]);
                        tmpList.add(nums[j]);
                        tmpList.add(nums[left]);
                        tmpList.add(nums[right]);
                        resultList.add(tmpList);

                        while (left<right && nums[left]==nums[left+1]){
                            left++;
                        }

                        while (left<right && nums[right] == nums[right-1]){
                            right--;
                        }

                        left++;
                        right--;

                    }else if(sum>target){
                        right--;
                    }else {
                        left++;
                    }



                }
            }
        }

        return resultList;

    }

    public static void main(String[] args) {
        int[] arrs = {1, 0, -1, 0, -2, 2};
        System.out.println(fourSum(arrs,0));

        int[] arrs1 = {0,0,0,0};
        System.out.println(fourSum(arrs1,0));

        int[] arrs2 = {-1,0,1,2,-1,-4};
        System.out.println(fourSum(arrs2,-1));

        int[] arrs3 = {-3,-2,-1,0,0,1,2,3};
        System.out.println(fourSum(arrs3,0));
    }
}

