class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] forward = new int[256], backward = new int[256]; Arrays.fill(forward, -1); Arrays.fill(backward, -1);
        for (int index = 0; index < s.length(); index++) { int first = s.charAt(index), second = t.charAt(index); if (forward[first] == -1 && backward[second] == -1) { forward[first] = second; backward[second] = first; } else if (forward[first] != second || backward[second] != first) return false; }
        return true;
    }
}
