class Solution {
    public int[] processQueries(int[] queries,int m){
        List<Integer> permutation=new ArrayList<>();
        for(int value=1;value<=m;value++)permutation.add(value);
        int[] answer=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int index=permutation.indexOf(queries[i]);
            answer[i]=index;
            permutation.remove(index);
            permutation.add(0,queries[i]);
        }
        return answer;
    }
}
