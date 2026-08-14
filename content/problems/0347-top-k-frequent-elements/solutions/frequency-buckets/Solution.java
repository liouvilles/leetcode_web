class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counts = new LinkedHashMap<>(); for (int value : nums) counts.put(value, counts.getOrDefault(value, 0) + 1);
        List<List<Integer>> buckets = new ArrayList<>(); for (int i = 0; i <= nums.length; i++) buckets.add(new ArrayList<>());
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) buckets.get(entry.getValue()).add(entry.getKey());
        int[] answer = new int[k]; int index = 0;
        for (int frequency = nums.length; frequency > 0 && index < k; frequency--) for (int value : buckets.get(frequency)) { answer[index++] = value; if (index == k) break; }
        return answer;
    }
}
