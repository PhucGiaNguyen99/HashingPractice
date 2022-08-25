import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    // Given an integer array containing duplicates, return the majority element if present. A majority element
    // element appears more than n/2 times, where n is the array size.

    // Brute-Force solution
    // A naive solution is to count each element's frequency in the first half of the array to check if it is the majority element.
    public int findMajorityElementNaive(int[] nums, int n) {
        for (int i = 0; i <= n / 2; i++) {
            int count = 1;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] == nums[i]) {
                    count++;
                }
            }
            if (count > n / 2) {
                return nums[i];
            }
        }
        return -1;
    }

    // Linear-time solution
    // Using hashing to solve this problem in linear time. The idea is to store each element's frequency in a map and
    // return if its frequency becomes more than n/2. If no such element is present, then return -1.
    public static int findMajorityElement(int[] nums) {
        // create an empty Hashmap
        Map<Integer, Integer> map = new HashMap<>();

        // store each element's frequency in a map
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        // return the element if its count is more than n/2
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > nums.length / 2) {
                return entry.getKey();
            }
        }
        return -1;
    }
    // The complexity is O(n) and requires O(n) extra space.

}
