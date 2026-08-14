class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> answer = new ArrayList<>(); int index = 0;
        while (index < intervals.length && intervals[index][1] < newInterval[0]) answer.add(intervals[index++]);
        while (index < intervals.length && intervals[index][0] <= newInterval[1]) { newInterval[0] = Math.min(newInterval[0], intervals[index][0]); newInterval[1] = Math.max(newInterval[1], intervals[index++][1]); }
        answer.add(newInterval); while (index < intervals.length) answer.add(intervals[index++]);
        return answer.toArray(new int[answer.size()][]);
    }
}
