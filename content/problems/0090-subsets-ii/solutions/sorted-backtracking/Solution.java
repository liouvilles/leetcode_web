class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) { Arrays.sort(nums); List<List<Integer>> answer = new ArrayList<>(); backtrack(0, nums, new ArrayList<>(), answer); return answer; }
    private void backtrack(int start, int[] nums, List<Integer> path, List<List<Integer>> answer) { answer.add(new ArrayList<>(path)); for (int index = start; index < nums.length; index++) { if (index > start && nums[index] == nums[index - 1]) continue; path.add(nums[index]); backtrack(index + 1, nums, path, answer); path.remove(path.size() - 1); } }
}
