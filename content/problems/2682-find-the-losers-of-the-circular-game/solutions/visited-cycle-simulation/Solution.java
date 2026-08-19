class Solution {
    public int[] circularGameLosers(int n,int k){
        boolean[] visited=new boolean[n];
        int current=0,round=1;
        while(!visited[current]){
            visited[current]=true;
            current=(current+round*k)%n;
            round++;
        }
        int count=0;
        for(boolean value:visited)if(!value)count++;
        int[] answer=new int[count];
        for(int i=0,index=0;i<n;i++)if(!visited[i])answer[index++]=i+1;
        return answer;
    }
}
