package com.joseph.array;

/**
 * Created by hlw on 19-6-4.
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，
 * 垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水
 */
public class MaxArea {
    public static void main(String[] args){

        int [] arrs = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(arrs));
        System.out.println(maxArea2(arrs));

    }

    public static int maxArea(int[] height) {

        if (height==null || height.length==0){
            return 0;
        }


        int result = 0;
        for (int i=0;i<height.length;i++){
            for (int j=i+1;j<height.length;j++){
                int tmp = (j-i)*Math.min(height[i],height[j]);
                result = Math.max(tmp,result);
            }
        }


        return result;

    }

    public static int maxArea2(int[] height) {

        if (height==null || height.length==0){
            return 0;
        }


        int result = 0;
        int i=0,j=height.length-1;

        while (i<j){
            result = Math.max(result,(j-i)*Math.min(height[i],height[j]));
            if (height[i]>height[j]){
                j--;
            }else {
                i++;
            }
        }


        return result;

    }
}
