class Solution {
    private final Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        int target = nums.length - k, left = 0, right = nums.length - 1;
        while (left <= right) {
            int pivot = partition(nums, left, right);
            if (pivot == target) return nums[pivot];
            if (pivot < target) left = pivot + 1; else right = pivot - 1;
        }
        throw new IllegalStateException();
    }

    private int partition(int[] a, int left, int right) {
        int pick = left + random.nextInt(right - left + 1);
        swap(a, pick, right);
        int store = left;
        for (int i = left; i < right; i++) if (a[i] < a[right]) swap(a, store++, i);
        swap(a, store, right);
        return store;
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i]; a[i] = a[j]; a[j] = temp;
    }
}
