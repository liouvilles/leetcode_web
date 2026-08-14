class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        build(nums, new boolean[nums.length], new ArrayList<>(), answer);
        return answer;
    }

    private void build(int[] nums, boolean[] used, List<Integer> path, List<List<Integer>> answer) {
        if (path.size() == nums.length) {
            answer.add(new ArrayList<>(path));
            return;
        }
        for (int index = 0; index < nums.length; index++) {
            if (used[index]) continue;
            used[index] = true;
            path.add(nums[index]);
            build(nums, used, path, answer);
            path.remove(path.size() - 1);
            used[index] = false;
        }
    }
}
