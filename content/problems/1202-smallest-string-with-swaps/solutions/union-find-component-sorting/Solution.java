class Solution {
    public String smallestStringWithSwaps(String s,List<List<Integer>> pairs){
        int n=s.length();
        int[] parent=new int[n];
        for(int i=0;i<n;i++)parent[i]=i;
        for(List<Integer> pair:pairs)union(parent,pair.get(0),pair.get(1));
        Map<Integer,List<Integer>> groups=new HashMap<>();
        for(int i=0;i<n;i++)groups.computeIfAbsent(find(parent,i),key->new ArrayList<>()).add(i);
        char[] answer=s.toCharArray();
        for(List<Integer> indices:groups.values()){
            char[] letters=new char[indices.size()];
            for(int i=0;i<indices.size();i++)letters[i]=s.charAt(indices.get(i));
            Arrays.sort(letters);
            for(int i=0;i<indices.size();i++)answer[indices.get(i)]=letters[i];
        }
        return new String(answer);
    }
    private int find(int[] parent,int node){
        if(parent[node]!=node)parent[node]=find(parent,parent[node]);
        return parent[node];
    }
    private void union(int[] parent,int a,int b){
        int rootA=find(parent,a),rootB=find(parent,b);
        if(rootA!=rootB)parent[rootB]=rootA;
    }
}
