import java.util.*;

class ValidAnagram {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) return false;

        
        int[] count = new int[26]; // assuming lowercase letters only
        s = s.toLowerCase();
        t = t.toLowerCase();

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int c : count) {
            if (c != 0) return false;
        }
        return true;
    }

public static void main(String args[]){
    ValidAnagram va = new ValidAnagram();
    System.out.println(va.isAnagram("anagram", "nagaram")); // true
    System.out.println(va.isAnagram("rat", "tar")); // false
}}