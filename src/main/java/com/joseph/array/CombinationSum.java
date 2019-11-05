package com.joseph.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        backTrace(res,list,candidates,target,target,0);
        return res;
    }
    public void backTrace(List<List<Integer>> res,List<Integer> list,int[] nums,int target,int remain,int start){
        if(remain < 0)
            return;
        if(remain == 0){
            res.add(new ArrayList<Integer>(list));
        }else{
            for(int i=start;i<nums.length;i++){
                list.add(nums[i]);
                backTrace(res,list,nums,target,remain-nums[i],i);
                list.remove(list.size() - 1);
            }
        }
    }


    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        int [] nums = {2,3,6,7};
        List<List<Integer>> list = combinationSum.combinationSum(nums,7);
        for (List<Integer> list1:list){
            System.out.println(list1.toString());
        }
    }



}
