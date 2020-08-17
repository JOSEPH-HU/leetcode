package com.joseph.str;

import java.util.LinkedHashSet;

//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//
// 示例 1:
//
// 输入: "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//
//
// 示例 2:
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//
//
// 示例 3:
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
public class LengthOfLongestSubstring{
	public static void main(String[] args) {
		//String s = "abcabcbb";
		//String s = "bbbbb";
		//String s = "pwwkew";
		String s = " ";
		System.out.println(solution(s));

	}

	public static int solution(String s){
		//存放字符串
		LinkedHashSet<Character> set = new LinkedHashSet<Character>();
		//子串的长度
		int result = 0;
		//右指针的位置
		int rk = 0;
		int len = s.length();
		for(int i=0;i<len;i++){
			if(i!=0){
				set.remove(s.charAt(i-1));
			}
			while(rk<len&&!set.contains(s.charAt(rk))){
				set.add(s.charAt(rk));
				++rk;
			}
			result = Math.max(result, set.size());
		}
		return result;
	}
}
