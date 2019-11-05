package com.joseph.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 */
public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
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
                if (i>start && nums[i-1]==nums[i]){
                    continue;
                }
                list.add(nums[i]);
                backTrace(res,list,nums,target,remain-nums[i],i+1);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {

        CombinationSum2 combinationSum = new CombinationSum2();
        int [] nums = {10,1,2,7,6,1,5};
        List<List<Integer>> list = combinationSum.combinationSum2(nums,8);
        for (List<Integer> list1:list){
            System.out.println(list1.toString());
        }
    }
}
