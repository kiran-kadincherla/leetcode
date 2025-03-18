class Solution {
      private Map<Integer, Integer> memo = new HashMap<>();
public int longestNiceSubarray(int[] nums) {
        int maxLength = 0;
        int left = 0;
        int andResult = 0; // Current AND result of the window

        for (int right = 0; right < nums.length; right++) {
            while ((andResult & nums[right]) != 0) {
                // Remove leftmost element if the AND condition is violated
                andResult ^= nums[left];
                left++;
            }
            andResult |= nums[right]; // Expand window
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    


}