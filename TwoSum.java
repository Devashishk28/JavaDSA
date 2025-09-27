//This is my first day for (javaDSA)
//here we covered topics like ARRAY,HASHTABLE
import java.util.*;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two solutions found");
    }

    public static void main(String[] args) {
        int[] nums = { 2, 7, 9, 11 };
        int target = 9;

        int[] result = twoSum(nums, target);
        System.out.println("[" + result[0] + "," + result[1] + "]");
    }
}
