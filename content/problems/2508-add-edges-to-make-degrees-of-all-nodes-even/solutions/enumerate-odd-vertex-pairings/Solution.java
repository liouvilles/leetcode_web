class Solution {
    private List<Set<Integer>> graph;
    private boolean missing(int a,int b){
        return !graph.get(a).contains(b);
    }
    public boolean isPossible(int n,List<List<Integer>> edges){
        graph=new ArrayList<>();
        for(int i=0;i<n;i++)graph.add(new HashSet<>());
        for(List<Integer> edge:edges){
            int a=edge.get(0)-1,b=edge.get(1)-1;
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        List<Integer> odd=new ArrayList<>();
        for(int i=0;i<n;i++)if(graph.get(i).size()%2==1)odd.add(i);
        if(odd.isEmpty())return true;
        if(odd.size()==2){
            int a=odd.get(0),b=odd.get(1);
            if(missing(a,b))return true;
            for(int c=0;c<n;c++)if(c!=a&&c!=b&&missing(a,c)&&missing(b,c))return true;
            return false;
        }
        if(odd.size()!=4)return false;
        int a=odd.get(0),b=odd.get(1),c=odd.get(2),d=odd.get(3);
        return missing(a,b)&&missing(c,d)||missing(a,c)&&missing(b,d)||missing(a,d)&&missing(b,c);
    }
}
