//Java 25+ only

void main() {
    int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
    merge(nums1, 3, new int[]{2, 5, 6}, 3);
    IO.println(Arrays.toString(nums1));

    nums1 = new int[]{1};
    merge(nums1, 1, new int[]{}, 0);
    IO.println(Arrays.toString(nums1));

    nums1 = new int[]{0};
    merge(nums1, 0, new int[]{1}, 1);
    IO.println(Arrays.toString(nums1));
}

// https://leetcode.com/problems/merge-sorted-array
private void merge(int[] nums1, int m, int[] nums2, int n) {

    for (int i = m + n - 1, m1 = m - 1, n1 = n - 1; n1 >= 0; i--) {
        if (m1 >= 0 && nums1[m1] > nums2[n1]) {
            nums1[i] = nums1[m1--];
        } else {
            nums1[i] = nums2[n1--];
        }
    }
}
