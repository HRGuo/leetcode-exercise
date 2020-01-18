package org.guo.leetCode;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0;
        int len = 0;
        Set<Character> substring = new HashSet<>();
        while (i < s.length() && j < s.length()) {
            if (substring.contains(s.charAt(j))) {
                substring.remove(s.charAt(i++));
            } else {
                substring.add(s.charAt(j++));
                len = Math.max(len ,substring.size());
            }
        }
        return len;
    }
}
