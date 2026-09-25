package TwoPointer;

public class RainWater {
    public static void main(String[] args) {
        int arr[] = {0,2,0,3,1,0,1,3,2,1};
        int sum = 0;
        //bruteforce
        extracted(arr, sum);
        //better
        better(arr);
        //optimized
        optimized(arr);
    }

    private static void optimized(int[] arr) {
        int sum2 =0;
        int left = 0;
        int right = arr.length-1;
        int leftMax = 0;
        int rightMax = 0;
        while(left<right) {
            leftMax = Math.max(arr[left],leftMax);
            rightMax = Math.max(arr[right],rightMax);
            if(leftMax<rightMax) {
                sum2 += Math.max(0, leftMax - arr[left]);
                left++;
            }else {
                sum2 += Math.max(0, rightMax - arr[right]);
                right--;
            }
        }
        System.out.println("The storage is 3rd approach is "+sum2);
    }

    private static void better(int[] arr) {
        int sum1 = 0;
        int[] leftArray = new int[arr.length];
        int[] rightArray = new int[arr.length];
        int leftMax = 0;
        int rightMax = 0;
        for(int i = 0; i< arr.length; i++) {
            leftArray[i] = Math.max(leftMax, arr[i]);
            leftMax = leftArray[i];
        }
        for(int i = arr.length-1; i>=0; i--) {
            rightArray[i] = Math.max(rightMax, arr[i]);
            rightMax = rightArray[i];
        }
        for(int i = 0; i< arr.length; i++){
            int storage = Math.min(leftArray[i],rightArray[i]) - arr[i];
            if(storage>0){
                sum1+=storage;
            }
        }
        System.out.println("The storage is 2nd approach is "+sum1);
    }

    private static void extracted(int[] arr, int sum) {
        for(int i = 1; i< arr.length-1; i++) {
            int leftMax = 0;
            int rightMax = 0;
            int left = 0;
            int right = i+1;
            while(left<i){
                leftMax = Math.max(arr[left],leftMax);
                left++;
            }
            while(right< arr.length){
                rightMax = Math.max(arr[right],rightMax);
                right++;
            }
            int minValue = Math.min(leftMax, rightMax);
            int storageWaterValue = minValue- arr[i];
            if(storageWaterValue>0) {
                sum +=storageWaterValue;
            }
        }
        System.out.println("Rain water storage is "+ sum);
    }
}
