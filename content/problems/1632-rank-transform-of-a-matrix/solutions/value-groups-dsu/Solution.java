class Solution {
    private static class DSU{
        int[] parent;
        DSU(int n){
            parent=new int[n];
            for(int i=0;i<n;i++)parent[i]=i;
        }
        int find(int x){
            return parent[x]==x?x:(parent[x]=find(parent[x]));
        }
        void union(int a,int b){
            a=find(a);
            b=find(b);
            if(a!=b)parent[a]=b;
        }
    }
    public int[][] matrixRankTransform(int[][] matrix){
        int rows=matrix.length,cols=matrix[0].length,total=rows*cols;
        int[][] cells=new int[total][2];
        for(int index=0;index<total;index++){
            cells[index][0]=index/cols;
            cells[index][1]=index%cols;
        }
        Arrays.sort(cells,(a,b)->Integer.compare(matrix[a[0]][a[1]],matrix[b[0]][b[1]]));
        int[] rowRank=new int[rows],colRank=new int[cols];
        int[][] answer=new int[rows][cols];
        for(int start=0;start<total;){
            int end=start,value=matrix[cells[start][0]][cells[start][1]];
            while(end<total&&matrix[cells[end][0]][cells[end][1]]==value)end++;
            DSU dsu=new DSU(rows+cols);
            for(int index=start;index<end;index++)dsu.union(cells[index][0],rows+cells[index][1]);
            Map<Integer,Integer> componentRank=new HashMap<>();
            for(int index=start;index<end;index++){
                int row=cells[index][0],col=cells[index][1],root=dsu.find(row);
                componentRank.merge(root,Math.max(rowRank[row],colRank[col])+1,Math::max);
            }
            for(int index=start;index<end;index++){
                int row=cells[index][0],col=cells[index][1];
                answer[row][col]=componentRank.get(dsu.find(row));
            }
            for(int index=start;index<end;index++){
                int row=cells[index][0],col=cells[index][1];
                rowRank[row]=Math.max(rowRank[row],answer[row][col]);
                colRank[col]=Math.max(colRank[col],answer[row][col]);
            }
            start=end;
        }
        return answer;
    }
}
