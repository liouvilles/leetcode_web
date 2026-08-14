class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> answer = new ArrayList<>();
        search(candidates, target, 0, new ArrayList<>(), answer);
        return answer;
    }

    private void search(int[] candidates, int remaining, int start, List<Integer> path, List<List<Integer>> answer) {
        if (remaining == 0) {
            answer.add(new ArrayList<>(path));
            return;
        }
        for (int index = start; index < candidates.length && candidates[index] <= remaining; index++) {
            path.add(candidates[index]);
            search(candidates, remaining - candidates[index], index, path, answer);
            path.remove(path.size() - 1);
        }
    }
}
