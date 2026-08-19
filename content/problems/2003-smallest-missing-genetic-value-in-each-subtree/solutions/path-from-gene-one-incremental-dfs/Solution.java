class Solution {
    List<Integer>[] children;
    int[] nums;
    boolean[] visited,seen;
    private void add(int node){
        if(visited[node])return;
        visited[node]=true;
        if(nums[node]<seen.length)seen[nums[node]]=true;
        for(int child:children[node])add(child);
    }
    public int[] smallestMissingValueSubtree(int[] parents,int[] nums){
        int n=parents.length;
        this.nums=nums;
        children=new List[n];
        for(int i=0;i<n;i++)children[i]=new ArrayList<>();
        int one=-1,maximum=1;
        for(int i=0;i<n;i++){
            if(i>0)children[parents[i]].add(i);
            if(nums[i]==1)one=i;
            maximum=Math.max(maximum,nums[i]);
        }
        int[] answer=new int[n];
        Arrays.fill(answer,1);
        if(one<0)return answer;
        visited=new boolean[n];
        seen=new boolean[maximum+n+2];
        int missing=1;
        for(int node=one;node!=-1;node=parents[node]){
            add(node);
            while(seen[missing])missing++;
            answer[node]=missing;
        }
        return answer;
    }
}
