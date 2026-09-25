package TwoPointer;

public class Palindrome {
    public static void main(String[] args) {
        String k = "Was it a car or a cat I saw?";
        String k1 = k.toLowerCase();
        boolean result = isPalindrome(k1);
        System.out.println("the result is "+result);
    }
    public static boolean isPalindrome(String s) {
        char[] c = s.toCharArray();
        int left = 0;
        int right = c.length-1;
        while(left<right){
            if (!Character.isLetterOrDigit(c[left]))
                left++;
            else if (!Character.isLetterOrDigit(c[right]))
                right--;
            else if (c[left]!=c[right]){
                return false;
            }
            else{
                left++;
                right--;
            }
        }
        return true;
    }
}
