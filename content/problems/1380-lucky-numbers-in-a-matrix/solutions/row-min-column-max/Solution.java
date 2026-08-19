class Solution {
    public List<Integer> luckyNumbers(int[][] matrix){
        int rows=matrix.length,cols=matrix[0].length;
        int[] rowMin=new int[rows],colMax=new int[cols];
        Arrays.fill(rowMin,Integer.MAX_VALUE);
        Arrays.fill(colMax,Integer.MIN_VALUE);
        for(int row=0;row<rows;row++)for(int col=0;col<cols;col++){
            rowMin[row]=Math.min(rowMin[row],matrix[row][col]);
            colMax[col]=Math.max(colMax[col],matrix[row][col]);
        }
        List<Integer> answer=new ArrayList<>();
        for(int row=0;row<rows;row++)for(int col=0;col<cols;col++)if(matrix[row][col]==rowMin[row]&&matrix[row][col]==colMax[col])answer.add(matrix[row][col]);
        return answer;
    }
}
