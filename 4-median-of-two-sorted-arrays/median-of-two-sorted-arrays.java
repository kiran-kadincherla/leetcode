class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Always binary search on the smaller array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int totalLength = nums1.length + nums2.length;
        int leftSize = (totalLength + 1) / 2;

        int low = 0;
        int high = nums1.length;

        while (low <= high) {

            // Partition in nums1
            int mid1 = low + (high - low) / 2;

            // Partition in nums2
            int mid2 = leftSize - mid1;

            double l1 = (mid1 == 0)
                    ? Double.NEGATIVE_INFINITY
                    : nums1[mid1 - 1];

            double r1 = (mid1 == nums1.length)
                    ? Double.POSITIVE_INFINITY
                    : nums1[mid1];

            double l2 = (mid2 == 0)
                    ? Double.NEGATIVE_INFINITY
                    : nums2[mid2 - 1];

            double r2 = (mid2 == nums2.length)
                    ? Double.POSITIVE_INFINITY
                    : nums2[mid2];

            // Correct partition
            if (l1 <= r2 && l2 <= r1) {

                // Odd number of elements
                if (totalLength % 2 != 0) {
                    return Math.max(l1, l2);
                }

                // Even number of elements
                return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
            }

            // Partition in nums1 is too far RIGHT
            if (l1 > r2) {
                high = mid1 - 1;
            }

            // Partition in nums1 is too far LEFT
            else {
                low = mid1 + 1;
            }
        }

        return 0.0;
    }
}