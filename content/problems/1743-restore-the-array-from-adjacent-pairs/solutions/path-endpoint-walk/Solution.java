class Solution {
    public int[] restoreArray(int[][] adjacentPairs){
        Map<Integer,List<Integer>> graph=new HashMap<>();
        for(int[] pair:adjacentPairs){
            graph.computeIfAbsent(pair[0],key->new ArrayList<>()).add(pair[1]);
            graph.computeIfAbsent(pair[1],key->new ArrayList<>()).add(pair[0]);
        }
        int start=0;
        outer:for(int[] pair:adjacentPairs)for(int value:pair)if(graph.get(value).size()==1){
            start=value;
            break outer;
        }
        int[] answer=new int[graph.size()];
        answer[0]=start;
        for(int i=1;i<answer.length;i++){
            List<Integer> neighbors=graph.get(answer[i-1]);
            answer[i]=neighbors.get(0);
            if(i>1&&answer[i]==answer[i-2])answer[i]=neighbors.get(1);
        }
        return answer;
    }
}
