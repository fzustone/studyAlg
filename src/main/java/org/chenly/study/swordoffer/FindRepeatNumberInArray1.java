package org.chenly.study.swordoffer;

import java.util.*;

/**
 * 剑指offer 03 数组中重复的数字
 *
 * @author chenly
 * @create 2020-11-04 21:00
 */
public class FindRepeatNumberInArray1 {
	public static void main(String[] args) {
		int[] a = new int[] { 1, 2,3,2 };
		System.out.println(findRepeatNumber(a));
	}

	//个人思路
	/*public static int findRepeatNumber(int[] nums) {

		HashSet<Integer> intSet = new HashSet<>();
		//Map<Integer,Boolean> map=new HashMap<>();
		return Arrays.stream(nums)
				.filter(num -> {
					if (intSet.contains(num)) {
						return true;
					}
					intSet.add(num);
					return false;
				})
				.findAny()
				.orElse(-1);
	}*/

	public static int findRepeatNumber(int[] nums) {
		int temp;
		for(int i=0;i<nums.length;i++){
			//用while的原因：要保证每一个元素都归位了，不然会出现前面的值再也无法被访问，导致漏判
			while (nums[i]!=i){
				if(nums[i]==nums[nums[i]]){
					return nums[i];
				}
				temp=nums[i];
				nums[i]=nums[temp];
				nums[temp]=temp;
			}
		}
		return -1;
	}

}
