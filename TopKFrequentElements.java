import java.util.*;

class TopKFrequentElements{
    public int[] topKFrequent(int[] nums, int k) {
        // Building freq map
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // creating a min heap
        PriorityQueue<Map.Entry<Integer, Integer>> heap =
                new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        //Maintaining heap size of k
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            heap.add(entry);
            if (heap.size() > k) {
                heap.poll();  // this remove least frequent
            }
        }

        // Building result array
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = heap.poll().getKey();
        }

        return result;
    }

    public static void main(String[] args) {
        TopKFrequentElements so = new TopKFrequentElements();
        int[] nums = {1, 1, 1, 2,3,2,3,3,3,3, 2, 3};
        int k = 2;

        int[] result = so.topKFrequent(nums, k);
        System.out.println("Top " + k + " frequent elements: " + Arrays.toString(result));
    }
}
