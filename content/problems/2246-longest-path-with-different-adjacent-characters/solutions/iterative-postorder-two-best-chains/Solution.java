class Solution {
    public int longestPath(int[] parent,String s){
        int n=parent.length;
        List<Integer>[] children=new List[n];
        for(int i=0;i<n;i++)children[i]=new ArrayList<>();
        for(int i=1;i<n;i++)children[parent[i]].add(i);
        int[] order=new int[n],down=new int[n];
        int size=0;
        Deque<Integer> stack=new ArrayDeque<>();
        stack.push(0);
        while(!stack.isEmpty()){
            int node=stack.pop();
            order[size++]=node;
            for(int child:children[node])stack.push(child);
        }
        int answer=1;
        for(int index=n-1;index>=0;index--){
            int node=order[index],first=0,second=0;
            for(int child:children[node])if(s.charAt(child)!=s.charAt(node)){
                int value=down[child];
                if(value>first){
                    second=first;
                    first=value;
                }else if(value>second)second=value;
            }
            down[node]=first+1;
            answer=Math.max(answer,first+second+1);
        }
        return answer;
    }
}
