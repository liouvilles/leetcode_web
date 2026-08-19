class Solution {
    public int[][] allCellsDistOrder(int rows,int cols,int rCenter,int cCenter){
        int[][] cells=new int[rows*cols][2];
        int index=0;
        for(int r=0;r<rows;r++)for(int c=0;c<cols;c++)cells[index++]=new int[]{
            r,c
        };
        Arrays.sort(cells,Comparator.<int[]>comparingInt(a->Math.abs(a[0]-rCenter)+Math.abs(a[1]-cCenter)).thenComparingInt(a->a[0]).thenComparingInt(a->a[1]));
        return cells;
    }
}
