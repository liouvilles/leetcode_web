class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> answer = new ArrayList<>();
        int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        while (top <= bottom && left <= right) {
            for (int column = left; column <= right; column++) answer.add(matrix[top][column]);
            top++;
            for (int row = top; row <= bottom; row++) answer.add(matrix[row][right]);
            right--;
            if (top <= bottom) { for (int column = right; column >= left; column--) answer.add(matrix[bottom][column]); bottom--; }
            if (left <= right) { for (int row = bottom; row >= top; row--) answer.add(matrix[row][left]); left++; }
        }
        return answer;
    }
}
