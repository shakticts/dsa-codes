package important_questions;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> last = new HashMap<>();
        int start = 0, best = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (last.containsKey(c)) start = Math.max(start, last.get(c) + 1);
            best = Math.max(best, i - start + 1);
            last.put(c, i);
        }
        return best;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println("Longest substring length of '"+s+"' = " + lengthOfLongestSubstring(s));
    }
}
