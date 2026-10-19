package SlidingWindow;

import java.util.Arrays;

public class Anagram {
    public static void main(String[] args) {
        String s = "caabab";
        String t = "aba";
        int numberOfAnagrams = anagram(s, t);
        System.out.println(numberOfAnagrams);
    }

    private static int anagram(String s, String t) {
        int count = 0;
        if (t.length() > s.length()) { 
            return 0;
        } else {
            int[] subStringfreq = new int[26];
            int[] windowFreq = new int[26];
            for (char ch : t.toCharArray()) {
                subStringfreq[ch - 'a'] += 1;
            }

            int left = 0;
            int right = 0;

            while (right < s.length()) {
                windowFreq[s.charAt(right) - 'a'] += 1;
                if (right - left + 1 == t.length()) {
                    if (Arrays.equals(subStringfreq, windowFreq)) {
                        count++;
                    }
                    windowFreq[s.charAt(left) - 'a'] -= 1;
                    left++;
                }
                right++;
            }

        }
        return count;
    }
}
