package com.joseph.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *注意重复结果出现
 * 这个是用双指针的方法实现的
 *
 * 关键点：1.数组进行排序；2.循环中对重复结果处理
 */

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {

        if(nums==null || nums.length<0){
            return null;
        }

        Arrays.sort(nums);//对数组排序

        List<List<Integer>> lists = new ArrayList<List<Integer>>();

        int len = nums.length - 1;

        for (int i=0;i<len;i++){
            if (i>0 && nums[i] == nums[i-1]){//跳过重复的值
                continue;
            }

            int left = i+1;
            int right = len;

            while (left<right){
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0){
                    List<Integer> tempList = new ArrayList<Integer>();
                    tempList.add(nums[i]);
                    tempList.add(nums[left]);
                    tempList.add(nums[right]);
                    lists.add(tempList);
                    while (left<right && nums[left] == nums[left+1]){//跳过重复值
                        left++;
                    }
                    while (left<right && nums[right] == nums[right-1]){//跳过重复值
                        right--;
                    }
                    left++;
                    right--;
                }else if(sum>0){
                    right--;
                }else {
                    left++;
                }
            }
        }

        return lists;

    }

    public static void main(String[] args) {

        int [] arrs = {-1, 0, 1, 2, -1, -4};

        System.out.println(threeSum(arrs));

    }


}
