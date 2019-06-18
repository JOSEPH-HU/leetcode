package com.joseph.array;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。
 * 假定每组输入只存在唯一答案。
 *
 * 注意点：1.最近的含义就是绝对值最小；2.采用两指针的方式，找到最接近的值，时间复杂度是O(n2)
 *
 */

public class ThreeSumClosest {

    public static int threeSumClosest(int[] nums, int target) {


        int len = nums.length - 1;
        int result = nums[0] + nums[1] + nums[2];

        Arrays.sort(nums);

        for (int i=0;i<=len;i++){

            int left = i + 1;
            int right = len;

            while(left<right){
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(target-sum)<Math.abs(target-result)){
                    result =  sum;
                }
                if(sum>target){
                    right--;
                }else if(sum<target){
                    left++;
                }else {
                    return result;
                }

            }
        }
        return result;

    }



    public static void main(String[] args) {
        int [] arrs = {-1,2,1,-4};
        System.out.println(threeSumClosest(arrs,2));


        int [] arrs1 = {1,1,1,0};
        System.out.println(threeSumClosest(arrs1,-100));
    }
}
