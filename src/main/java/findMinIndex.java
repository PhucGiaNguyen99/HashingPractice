import java.util.HashSet;
import java.util.Set;

public class findMinIndex {
    // Given an integer array, find teh minimum index of a repeating element in linear time and doing just
    // single traversal of the array

    // Using hashing, traverse the array from right to left, if the element is seen for the first time, insert it into
    // the set, otherwise, update the minimum index to the element's index.
    // Finally, return the minimum index after all elements are processed.

    public int findMinIndex(int[] arr) {
        int minIndex = arr.length;
        Set<Integer> set = new HashSet<>();

        // traverse the array from right to left
        for (int i = arr.length - 1; i >= 0; i--) {
            // if the element is seen before, update the minimum index
            if (set.contains(arr[i])) {
                minIndex = i;
            }

            // if the element is seen for the first time, insert it into the set
            else {
                set.add(arr[i]);
            }
        }

        // invalid input
        if (minIndex == arr.length) {
            return -1;
        }
        return minIndex;

    }
}
