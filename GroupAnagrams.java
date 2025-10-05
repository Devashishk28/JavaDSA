import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagramsCategorizedFrequency(String[] strs) {
        // check for empty inputs
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> frequencyStringsMap = new HashMap<>();

        for (String str : strs) {
            String frequencyString = getFrequencyString(str);

            // if the freq. string is present, add the string to the list
            if (frequencyStringsMap.containsKey(frequencyString)) {
                frequencyStringsMap.get(frequencyString).add(str);
            } else {
                // else create a new list 
                List<String> strList = new ArrayList<>();
                strList.add(str);
                frequencyStringsMap.put(frequencyString, strList);
            }
        }

        // return all grouped anagram lists
        return new ArrayList<>(frequencyStringsMap.values());
    }

    private String getFrequencyString(String str) {
        // frequency bucket
        int[] freq = new int[26];

        // iterate over each character
        for (char c : str.toCharArray()) {
            freq[c - 'a']++;
        }

        // create frequency string (acts as a unique signature)
        StringBuilder frequencyString = new StringBuilder();
        char c = 'a';
        for (int count : freq) {
            frequencyString.append(c);
            frequencyString.append(count);
            c++;
        }

        return frequencyString.toString();
    }

    // 🧠 main method to test
    public static void main(String[] args) {
        GroupAnagrams ga = new GroupAnagrams();
        String[] words = {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> result = ga.groupAnagramsCategorizedFrequency(words);
        System.out.println(result);
    }
}

