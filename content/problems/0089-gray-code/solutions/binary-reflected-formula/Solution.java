class Solution {
    public List<Integer> grayCode(int n) { List<Integer> answer = new ArrayList<>(); for (int value = 0; value < (1 << n); value++) answer.add(value ^ (value >> 1)); return answer; }
}
