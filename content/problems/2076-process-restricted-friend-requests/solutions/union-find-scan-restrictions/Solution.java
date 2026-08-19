class Solution {
    int[] parent;
    private int find(int value){
        return value==parent[value]?value:(parent[value]=find(parent[value]));
    }
    public boolean[] friendRequests(int n,int[][] restrictions,int[][] requests){
        parent=new int[n];
        for(int i=0;i<n;i++)parent[i]=i;
        boolean[] answer=new boolean[requests.length];
        for(int i=0;i<requests.length;i++){
            int first=find(requests[i][0]),second=find(requests[i][1]);
            boolean valid=true;
            for(int[] restriction:restrictions){
                int a=find(restriction[0]),b=find(restriction[1]);
                if(a==first&&b==second||a==second&&b==first){
                    valid=false;
                    break;
                }
            }
            if(valid){
                answer[i]=true;
                parent[first]=second;
            }
        }
        return answer;
    }
}
