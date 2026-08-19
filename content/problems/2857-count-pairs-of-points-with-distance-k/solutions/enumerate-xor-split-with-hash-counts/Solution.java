class Solution {
    private long key(int x,int y){
        return ((long)x<<32)^(y&0xffffffffL);
    }
    public int countPairs(List<List<Integer>> coordinates,int k){
        Map<Long,Integer> frequency=new HashMap<>();
        int answer=0;
        for(List<Integer> point:coordinates){
            int x=point.get(0),y=point.get(1);
            for(int deltaX=0;deltaX<=k;deltaX++)answer+=frequency.getOrDefault(key(x^deltaX,y^(k-deltaX)),0);
            long current=key(x,y);
            frequency.put(current,frequency.getOrDefault(current,0)+1);
        }
        return answer;
    }
}
