class Solution {
    fun minDistance(word1: String, word2: String): Int {
        val distance = Array(word1.length + 1) { IntArray(word2.length + 1) }
        for (first in 0..word1.length) distance[first][0] = first
        for (second in 0..word2.length) distance[0][second] = second
        for (first in 1..word1.length) for (second in 1..word2.length) distance[first][second] = if (word1[first - 1] == word2[second - 1]) distance[first - 1][second - 1] else 1 + minOf(distance[first - 1][second - 1], distance[first - 1][second], distance[first][second - 1])
        return distance[word1.length][word2.length]
    }
}
