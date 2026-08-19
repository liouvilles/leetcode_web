class Solution {
    int[] zero,one,count;
    int nodes=1;
    private void update(int value,int delta){
        int node=0;
        count[node]+=delta;
        for(int bit=18;bit>=0;bit--){
            int direction=(value>>bit)&1;
            int next=direction==0?zero[node]:one[node];
            if(next==0&&delta>0){
                next=nodes++;
                if(direction==0)zero[node]=next;
                else one[node]=next;
            }
            node=next;
            count[node]+=delta;
        }
    }
    private int best(int value){
        int node=0,answer=0;
        for(int bit=18;bit>=0;bit--){
            int direction=(value>>bit)&1,opposite=direction==0?one[node]:zero[node];
            if(opposite!=0&&count[opposite]>0){
                answer|=1<<bit;
                node=opposite;
            }else node=direction==0?zero[node]:one[node];
        }
        return answer;
    }
    public int[] maxGeneticDifference(int[] parents,int[][] queries){
        int n=parents.length,root=0;
        List<Integer>[] children=new List[n];
        List<int[]>[] attached=new List[n];
        for(int i=0;i<n;i++){
            children[i]=new ArrayList<>();
            attached[i]=new ArrayList<>();
        }
        for(int i=0;i<n;i++)if(parents[i]<0)root=i;
        else children[parents[i]].add(i);
        for(int i=0;i<queries.length;i++)attached[queries[i][0]].add(new int[]{
            queries[i][1],i
        });
        int capacity=(n+1)*20;
        zero=new int[capacity];
        one=new int[capacity];
        count=new int[capacity];
        int[] answer=new int[queries.length];
        Deque<int[]> stack=new ArrayDeque<>();
        stack.push(new int[]{
            root,0
        });
        while(!stack.isEmpty()){
            int[] event=stack.pop();
            int node=event[0];
            if(event[1]==1){
                update(node,-1);
                continue;
            }
            update(node,1);
            for(int[] query:attached[node])answer[query[1]]=best(query[0]);
            stack.push(new int[]{
                node,1
            });
            List<Integer> list=children[node];
            for(int i=list.size()-1;i>=0;i--)stack.push(new int[]{
                list.get(i),0
            });
        }
        return answer;
    }
}
