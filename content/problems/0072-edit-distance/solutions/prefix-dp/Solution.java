class Solution {
    public int minDistance(String word1, String word2) {
        int[][] distance = new int[word1.length() + 1][word2.length() + 1];
        for (int first = 0; first <= word1.length(); first++) distance[first][0] = first;
        for (int second = 0; second <= word2.length(); second++) distance[0][second] = second;
        for (int first = 1; first <= word1.length(); first++) for (int second = 1; second <= word2.length(); second++) {
            if (word1.charAt(first - 1) == word2.charAt(second - 1)) distance[first][second] = distance[first - 1][second - 1];
            else distance[first][second] = 1 + Math.min(distance[first - 1][second - 1], Math.min(distance[first - 1][second], distance[first][second - 1]));
        }
        return distance[word1.length()][word2.length()];
    }
}
