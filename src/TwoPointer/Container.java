package TwoPointer;

public class Container {
    public static void main(String[] args) {
        int arr[]={2,9,10,12,5,3,6,8};
        int left = 0;
        int right = arr.length-1;
        int maxArea = 0;

        while(left<right){
            int min = Math.min(arr[left], arr[right]);
            int area = min*(right-left);
            if(area>maxArea){
                maxArea=area;
            }
            if(arr[left]<arr[right]){
                left++;
            }
            else if(arr[left]>arr[right]){
                right--;
            }else{
                left++;
                right--;
            }
        }
        System.out.println("The maximum area of the container is "+maxArea);
    }
}
