package com.joseph.str;

import java.util.ArrayList;
import java.util.List;

/**
 * 目标，计算从 start到end出现次数为奇数次的字母的个数c ,如果 c <=2*k+1 则一定可以变成回文串 因为c最大是26，所以k如果>=13 则一定可以变成回文串
 *
 * 预处理s
 * 把 ‘a’-'z' 看成一个26位的二进制数，如果某个字母出现了奇数次，记为1 如果出现了偶数次，记为0
 * 这样 d[i] 表示到s 的第i个字符时，表示的数字
 *
 * 处理 queries
 *
 * 奇数-奇数 = 偶数
 * 奇数-偶数 = 奇数
 * 偶数-偶数 = 偶数
 * 偶数-奇数 = 奇数
 *
 * 正是 异或 的结果
 *
 * 对结果取二进制中1的个数，参考 java 版 bitCount 方法，分治 计算1的个数，需要5步
 * 1 每1位计算 1的个数和
 * 2 每2位计算 1的个数和
 * 3 每4位计算 1的个数和
 * 4 每8位计算 1的个数和
 * 5 每16位计算 1的个数和
 *
 */

public class CanMakePaliQueries {
    public static void main(String[] args){

        String s = "abcda";
        int[][] queries = {{3,3,0},{1,2,0},{0,3,1},{0,3,2},{0,4,1}};
        List<Boolean> list = solution(s,queries);
        for(Boolean b:list){
            System.out.println(b);
        }

    }

    public static List<Boolean> solution(String s , int[][] queries){
        List<Boolean> ret = new ArrayList<Boolean>(queries.length);
        int[] memo = new int[s.length()];
        int tp = 0;
        for (int i = 0; i < s.length(); i++) {
            int bit = s.charAt(i)-'a';
            System.out.println("bit=" + bit);
            int tmp = 1<<bit;
            System.out.println("tmp=" + tmp);
            tp ^= tmp;
            memo[i] = tp;
        }

        for(int a:memo){
            System.out.println(a);
        }
        for (int[] query : queries) {
            int odd = 0;
            int a = query[0]>0?memo[query[0]-1]:0;
            int b = memo[query[1]];
            System.out.println("a=" + a + "|b=" + b);
            int r = a ^ b;
            while (r != 0){
                if ((r & 1) == 1){
                    odd++;
                }
                r >>= 1;
            }
            ret.add(query[2]>=odd/2);
        }
        return ret;
    }
}
