import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Create a HashMap to store numbers we've seen and their indices.
        Map<Integer, Integer> numMap = new HashMap<>();

        // Iterate through the array.
        for (int i = 0; i < nums.length; i++) {
            // Calculate the complement needed to reach the target.
            int complement = target - nums[i];

            // Check if the complement exists in our map.
            if (numMap.containsKey(complement)) {
                // If it exists, we found our pair.
                return new int[] { numMap.get(complement), i };
            }

            // If the complement is not found, add the current number and its index to the map.
            numMap.put(nums[i], i);
        }

        // If no solution is found, throw an exception (as per problem statement, a solution always exists).
        throw new IllegalArgumentException("No two sum solution");
    }
}