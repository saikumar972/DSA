package TwoPointer;

public class ThreeSum {
    public static void main(String[] args) {
        int[] arr1 = { -3, -2, -2, 5, 5, 5 };
        int[] arr = { -1, 0, 1, 2, -1, -4 };
        for (int i = 0; i < arr.length - 2; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = arr.length - 1;
            while (left < right) {
                int target = -arr[i];
                int sum = arr[left] + arr[right];
                if (sum == target) {
                    System.out.println("the triplet were " + arr[i] + " " + arr[left] + " " + arr[right]);
                    left++;
                    right--;
                    while (left < right && arr[left] == arr[left - 1])
                        left++;
                    while (left < right && arr[right] == arr[right + 1])
                        right--;
                } else if (sum > target) {
                    right--;
                } else {
                    left++;
                }

            }
        }
    }
}
