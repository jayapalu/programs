package easy;

import java.util.HashSet;
import java.util.Set;

public class L242_ValidAnogram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";

        boolean result = isAnagramCharCount(s, t);
        System.out.println("is anagram: " + result);
    }

    static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int c : count) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }

    static boolean isAnagramCharCount(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int charCount[] = new int[26];

        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            charCount[c - 'a']--;
        }

        for (int count : charCount) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    //THIS WILL NOT WORK for unequal frequency of characters. ex: "aabb" and "ab"
    static boolean isAnagramSet(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();

        for (Character c : s.toCharArray()) {
            set1.add(c);
        }

        for (Character c : t.toCharArray()) {
            set2.add(c);
        }

        return set1.equals(set2);

    }
}

