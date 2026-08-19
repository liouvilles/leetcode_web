class Solution {
    public int[] colorTheArray(int n,int[][] queries){
        int[] colors=new int[n],answer=new int[queries.length];
        int pairs=0;
        for(int i=0;i<queries.length;i++){
            int index=queries[i][0],color=queries[i][1],old=colors[index];
            if(old!=0){
                if(index>0&&colors[index-1]==old)pairs--;
                if(index+1<n&&colors[index+1]==old)pairs--;
            }
            colors[index]=color;
            if(index>0&&colors[index-1]==color)pairs++;
            if(index+1<n&&colors[index+1]==color)pairs++;
            answer[i]=pairs;
        }
        return answer;
    }
}
