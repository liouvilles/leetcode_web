class Solution {
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color) {
        int original = image[sr][sc];
        if (original != color) fill(image, sr, sc, original, color);
        return image;
    }

private:
    void fill(vector<vector<int>>& image, int row, int col, int original, int color) {
        if (row < 0 || row == (int)image.size() || col < 0 || col == (int)image[0].size()
                || image[row][col] != original) return;
        image[row][col] = color;
        fill(image, row + 1, col, original, color); fill(image, row - 1, col, original, color);
        fill(image, row, col + 1, original, color); fill(image, row, col - 1, original, color);
    }
};
