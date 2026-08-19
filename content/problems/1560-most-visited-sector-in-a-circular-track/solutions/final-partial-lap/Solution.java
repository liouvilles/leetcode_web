class Solution {
    public List<Integer> mostVisited(int n,int[] rounds){
        int start=rounds[0],end=rounds[rounds.length-1];
        List<Integer> answer=new ArrayList<>();
        if(start<=end)for(int sector=start;sector<=end;sector++)answer.add(sector);
        else{
            for(int sector=1;sector<=end;sector++)answer.add(sector);
            for(int sector=start;sector<=n;sector++)answer.add(sector);
        }
        return answer;
    }
}
