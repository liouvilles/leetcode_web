class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        build(nums, 0, new ArrayList<>(), answer);
        return answer;
    }

    private void build(int[] nums, int start, List<Integer> path, List<List<Integer>> answer) {
        answer.add(new ArrayList<>(path));
        for (int index = start; index < nums.length; index++) {
            path.add(nums[index]);
            build(nums, index + 1, path, answer);
            path.remove(path.size() - 1);
        }
    }
}
