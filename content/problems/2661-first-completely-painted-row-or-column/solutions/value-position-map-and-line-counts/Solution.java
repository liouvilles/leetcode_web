class Solution {
    public int firstCompleteIndex(int[] arr,int[][] mat){
        int rows=mat.length,cols=mat[0].length;
        Map<Integer,Integer> position=new HashMap<>();
        for(int row=0;row<rows;row++)for(int col=0;col<cols;col++)position.put(mat[row][col],row*cols+col);
        int[] rowCount=new int[rows],colCount=new int[cols];
        for(int i=0;i<arr.length;i++){
            int encoded=position.get(arr[i]),row=encoded/cols,col=encoded%cols;
            if(++rowCount[row]==cols||++colCount[col]==rows)return i;
        }
        return -1;
    }
}
