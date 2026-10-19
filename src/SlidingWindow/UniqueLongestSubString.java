package SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;

public class UniqueLongestSubString {
    public static void main(String[] args) {
        String s = "pwwkew";
        int result = uniqueLongestSubString(s);
        System.out.println(result);
        int result2 = uniqueLongestSubString2(s);
        System.out.println(result2);
    }

    private static int uniqueLongestSubString(String s) {
        int right = 0;
        int left = 0;
        HashSet<Character> set = new HashSet<>();
        int max_length = 0;
        while (right < s.length()) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            max_length = Math.max(max_length, right - left + 1);
            right++;
        }
        return max_length;
    }

    private static int uniqueLongestSubString2(String s) {
        int right = 0;
        int left = 0;
        HashMap<Character, Integer> prev_index = new HashMap<>();
        int max_length = 0;
        while (right < s.length()) {
            if (prev_index.containsKey(s.charAt(right))) {
                int prevCharIndex = prev_index.get(s.charAt(right));
                if (prevCharIndex >= left) {
                    left = prevCharIndex + 1;
                }
            }
            max_length = Math.max(max_length, right - left + 1);
            prev_index.put(s.charAt(right), right);
            right++;
        }
        return max_length;
    }
}
