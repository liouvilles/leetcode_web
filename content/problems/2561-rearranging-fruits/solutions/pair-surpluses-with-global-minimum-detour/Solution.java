class Solution {
    public long minCost(int[] basket1,int[] basket2){
        Map<Integer,Integer> difference=new HashMap<>();
        int minimum=Integer.MAX_VALUE;
        for(int value:basket1){
            difference.merge(value,1,Integer::sum);
            minimum=Math.min(minimum,value);
        }
        for(int value:basket2){
            difference.merge(value,-1,Integer::sum);
            minimum=Math.min(minimum,value);
        }
        List<Integer> first=new ArrayList<>(),second=new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry:difference.entrySet()){
            int count=entry.getValue();
            if(Math.abs(count)%2==1)return -1;
            for(int i=0;i<count/2;i++)first.add(entry.getKey());
            for(int i=0;i<-count/2;i++)second.add(entry.getKey());
        }
        Collections.sort(first);
        second.sort(Comparator.reverseOrder());
        long cost=0;
        for(int i=0;i<first.size();i++)cost+=Math.min(Math.min(first.get(i),second.get(i)),2L*minimum);
        return cost;
    }
}
