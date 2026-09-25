package TwoPointer;

import java.util.Arrays;

public class TargetSum {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 4, 5, 7, 9};
        int targetSum = 9;
        //O(n2)
        for (int i = 0; i < arr1.length; i++) {
            for (int j = i + 1; j < arr1.length; j++) {
                if (arr1[i] + arr1[j] == targetSum) {
                    System.out.println("Indexes were " + i + " " + j);
                }
            }
        }
        //O(n)
        int left = 0;
        int right = arr1.length - 1;
        while (left < right) {
            if (arr1[left] + arr1[right] == targetSum) {
                System.out.println("Indexes were " + left + " " + right);
                left++;
                right--;
            } else if (arr1[left] + arr1[right] > targetSum) {
                right--;
            } else {
                left++;
            }
        }
        //calling method
        System.out.println("----------------");
        int[] result = twoSum(arr1,targetSum);
        System.out.println(Arrays.toString(result));
    }

    public static int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int[] result =new int[2];
        while (left<right){
            if(nums[left]+nums[right]==target){
                result[0]=left;
                result[1]=right;
                break;
            }
            else if(nums[left]+nums[right]>target){
                right--;
            }else {
                left++;
            }
        }
        return result;
    }
}
