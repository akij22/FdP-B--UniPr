package lez02;

import java.util.Arrays;

/*
 * 
 * Given an array of integers nums and an integer target, return indices of the two numbers 
 * such that they add up to target.

 * You may assume that each input would have exactly one solution, 
 * and you may not use the same element twice.

You can return the answer in any order.*/

public class LeetCodeProb1 {
	
	public static int[] twoSum(int[] arr, int target) {
		int[] finalIndex = new int[2];
		
		
		
		for(int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] + arr[j] == target) {
					finalIndex[0] = i;
					finalIndex[1] = j;
					return finalIndex;
				}
			}
		}
		
		System.out.println("Indici non trovati...");
		return finalIndex;
	}

	public static void main(String[] args) {
		int[] elements = {3, 2, 3};
		int target = 6;
		
		
		int[] finalI = twoSum(elements, target);
		
		System.out.println(Arrays.toString(finalI));

	}

}
