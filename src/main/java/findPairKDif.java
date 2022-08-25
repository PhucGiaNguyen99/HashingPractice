import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class findPairKDif {
    // The problem is to find a pair with the given difference in the array.
    // This methods does not handle duplicates in the array.
    public void findPair(int[] nums, int diff) {
        // create an empty set
        Set<Integer> set = new HashSet<>();

        for (int i : nums) {
            // check if pair with the given difference (i, i-diff) exists
            if (set.contains(i - diff)) {
                System.out.println("(" + i + ", " + (i - diff) + ")");
            }

            // check if pair with difference (i, i+diff) exists
            if (set.contains(i + diff)) {
                System.out.println("(" + i + ", " + (i + diff) + ")");
            }
            // insert the current element into the set
            set.add(i);
        }
    }

    // handle duplicates
    public void findPair2(int[] nums, int diff) {
        // sort array in ascending order
        Arrays.sort(nums);

        // create an empty set
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            // to avoid printing duplicates (skip adjacent duplicates)
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i++;
            }
            if (set.contains(nums[i] - diff)) {
                System.out.println("(" + nums[i] + ", " + (nums[i] - diff) + ")");
            }

            // check if pair with difference (i, i+diff) exists
            if (set.contains(nums[i] + diff)) {
                System.out.println("(" + nums[i] + ", " + (nums[i] + diff) + ")");
            }
            // insert the current element into the set
            set.add(nums[i]);
        }
    }
    // requires O(nlogn) and O(n) space extra.
}
