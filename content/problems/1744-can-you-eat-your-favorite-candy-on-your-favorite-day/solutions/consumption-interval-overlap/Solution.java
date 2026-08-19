class Solution {
    public List<Boolean> canEat(int[] candiesCount,int[][] queries){
        long[] prefix=new long[candiesCount.length+1];
        for(int i=0;i<candiesCount.length;i++)prefix[i+1]=prefix[i]+candiesCount[i];
        List<Boolean> answer=new ArrayList<>();
        for(int[] query:queries){
            long minimum=(long)query[1]+1,maximum=minimum*query[2];
            int type=query[0];
            answer.add(maximum>prefix[type]&&minimum<=prefix[type+1]);
        }
        return answer;
    }
}
