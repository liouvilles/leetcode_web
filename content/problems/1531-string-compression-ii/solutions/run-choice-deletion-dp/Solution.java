class Solution {
    private String text;
    private int[][] memo;
    private int encoded(int count){
        return count==1?1:count<10?2:count<100?3:4;
    }
    private int dfs(int index,int k){
        if(text.length()-index<=k)return 0;
        if(k<0)return 1_000_000;
        if(memo[index][k]!=-1)return memo[index][k];
        int answer=dfs(index+1,k-1),same=0,removed=0;
        for(int end=index;end<text.length();end++){
            if(text.charAt(end)==text.charAt(index))same++;
            else removed++;
            if(removed>k)break;
            answer=Math.min(answer,encoded(same)+dfs(end+1,k-removed));
        }
        return memo[index][k]=answer;
    }
    public int getLengthOfOptimalCompression(String s,int k){
        text=s;
        memo=new int[s.length()][k+1];
        for(int[] row:memo)Arrays.fill(row,-1);
        return dfs(0,k);
    }
}
