//Dsa day 11
//Topics:Arr,HAstTable,UnionFind
import java.util.HashSet;
import java.util.Set;

class LongestSequence {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Set<Integer> set = new HashSet<>();//Step 1: creating hashset for saving numbers
        for (int num : nums) set.add(num);

        int longest = 0;

        for (int num : set) {//step2:For each number in the set
            // only start counting if it's the beginning of a sequence
            if (!set.contains(num - 1)) { //Checking if (n-1 exists in the set or not)
                int current = num;
                int streak = 1;

                while (set.contains(current + 1)) {//step 4:keeping going forward until(num+1) not in the set
                    current++;
                    streak++;
                }
                longest = Math.max(longest, streak);//step 5:Track longest streak
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        LongestSequence los = new LongestSequence();
        int[] nums1 = {100, 4, 200, 3, 2, 1};
        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};

        System.out.println("Longest consecutive sequence length: " + los.longestConsecutive(nums1));
        System.out.println("Longest consecutive sequence length: " + los.longestConsecutive(nums2));
    }
}

