class Solution {
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color) {
        int original = image[sr][sc];
        if (original == color) return image;
        const int directions[5] = {1, 0, -1, 0, 1};
        queue<pair<int, int>> cells;
        cells.push({sr, sc});
        image[sr][sc] = color;
        while (!cells.empty()) {
            auto [r, c] = cells.front(); cells.pop();
            for (int d = 0; d < 4; ++d) {
                int row = r + directions[d], col = c + directions[d + 1];
                if (row >= 0 && row < (int)image.size() && col >= 0 && col < (int)image[0].size()
                        && image[row][col] == original) {
                    image[row][col] = color;
                    cells.push({row, col});
                }
            }
        }
        return image;
    }
};
