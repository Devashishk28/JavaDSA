import java.util.*;

class MinWindSubstr {//Note that i=windostart and j=windowEnd;
    public String minWindow(String s, String t) {
        int i = 0, j = 0, minLength = Integer.MAX_VALUE, start = 0;
        int matched = 0;

        Map<Character, Integer> tMap = new HashMap<>();
        for (char ch : t.toCharArray()) {
            tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
        }

        for (j = 0; j < s.length(); j++) {
            char currChar = s.charAt(j);
            if (tMap.containsKey(currChar)) {
                tMap.put(currChar, tMap.get(currChar) - 1);
                if (tMap.get(currChar) >= 0) {
                    matched += 1;
                }
            }
            while (matched == t.length()) {
                if (minLength > (j - i + 1)) {
                    minLength = j - i + 1;
                    start = i;
                }
                char leftChar = s.charAt(i++);
                if (tMap.containsKey(leftChar)) {
                    if (tMap.get(leftChar) == 0) {
                        matched -= 1;
                    }
                    tMap.put(leftChar, tMap.get(leftChar) + 1);
                }
            }
        }

        // ✅ return should be inside the method (before closing bracket)
        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
    }

    public static void main(String args[]) {
        MinWindSubstr mws = new MinWindSubstr();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String result = mws.minWindow(s, t);
        System.out.println("Minimum window substring is: " + result);
    }
}

//Mistakes i did while writing this code:Summary of fixes:

//1.Move main() inside the class.

//2.Keep the return statement inside the minWindow() method.

//3.Fix the print statement format.

//4.Maintain clean indentation.