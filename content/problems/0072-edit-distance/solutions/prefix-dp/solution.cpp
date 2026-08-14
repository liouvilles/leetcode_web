class Solution {
public:
    int minDistance(string word1, string word2) {
        vector<vector<int>> distance(word1.size() + 1, vector<int>(word2.size() + 1));
        for (int first = 0; first <= (int)word1.size(); ++first) distance[first][0] = first;
        for (int second = 0; second <= (int)word2.size(); ++second) distance[0][second] = second;
        for (int first = 1; first <= (int)word1.size(); ++first) for (int second = 1; second <= (int)word2.size(); ++second) {
            if (word1[first - 1] == word2[second - 1]) distance[first][second] = distance[first - 1][second - 1];
            else distance[first][second] = 1 + min({distance[first - 1][second - 1], distance[first - 1][second], distance[first][second - 1]});
        }
        return distance[word1.size()][word2.size()];
    }
};
