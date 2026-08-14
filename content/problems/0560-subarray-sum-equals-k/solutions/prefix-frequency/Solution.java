class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>(); counts.put(0, 1); int prefix = 0, answer = 0;
        for (int value : nums) { prefix += value; answer += counts.getOrDefault(prefix - k, 0); counts.put(prefix, counts.getOrDefault(prefix, 0) + 1); }
        return answer;
    }
}
