class Solution {
    public int[] kWeakestRows(int[][] mat,int k){
        Integer[] rows=new Integer[mat.length];
        int[] soldiers=new int[mat.length];
        for(int r=0;r<mat.length;r++){
            rows[r]=r;
            int left=0,right=mat[r].length;
            while(left<right){
                int middle=(left+right)/2;
                if(mat[r][middle]==1)left=middle+1;
                else right=middle;
            }
            soldiers[r]=left;
        }
        Arrays.sort(rows,(a,b)->soldiers[a]!=soldiers[b]?soldiers[a]-soldiers[b]:a-b);
        int[] answer=new int[k];
        for(int i=0;i<k;i++)answer[i]=rows[i];
        return answer;
    }
}
