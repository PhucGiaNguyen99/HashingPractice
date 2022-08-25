import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class findDuplicatesInKRange {
    // Given an array and a positive number k, check whether the array contains any duplicate elements
    // within the range k. If k is more than the array's size, the solution should check for duplicates in the complete array.

    // Naive solution: consider every subarray of size k and check for duplicates in it. The time complexity is O(n*k^2)
    // since there can be n subarrays of size k, and each subarray might take O(k^2) time for checking duplicates.

    // Using hashing, it is O(n) time and O(n) extra space.
    // The idea is to traverse the array and store the (element, index) pair in a map.
    // If any element is already found present on the map, check if the element repeats within the range of k using its previous occurrence information from the map
    public static boolean hasDuplicate(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            // if the current element already exists in the map
            if (map.containsKey(arr[i])) {
                // return true if the current element repeats within the range of k
                if (i - map.get(arr[i]) <= k) {
                    return true;
                }
            }
            // store elements with their indices
            map.put(arr[i], i);
        }
        return false;
    }

    // Using sliding window, the idea is to process every window of size k and store its elements in a set. If any
    // element repeats in the window, we can say that it repeats within the range of k.
    // Initially, our window will contain the first k elements of the input. Add element to the current window, while adding
    // the i'th item of the input to the current window, remove the (i-k)th element from it.
    public static boolean hasDupUsingSlidingWindows(int[] nums, int k) {
        Set<Integer> window = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (window.contains(nums[i])) {
                return true;
            }
            window.add(nums[i]);

            // remove the element at k'th range from the current element
            if (i >= k) {
                window.remove(nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {5, 6, 8, 2, 4, 6, 9};
        int k = 4;
        if (hasDuplicate(nums, k)) {
            System.out.println("Duplicates found!");
        } else {
            System.out.println("No duplicates were found!");
        }
    }
}
