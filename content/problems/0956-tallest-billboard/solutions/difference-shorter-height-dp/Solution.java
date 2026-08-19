class Solution {
    public int tallestBillboard(int[] rods){
        Map<Integer,Integer> dp=new HashMap<>();
        dp.put(0,0);
        for(int rod:rods){
            Map<Integer,Integer> next=new HashMap<>(dp);
            for(Map.Entry<Integer,Integer> entry:dp.entrySet()){
                int difference=entry.getKey(),shorter=entry.getValue();
                next.merge(difference+rod,shorter,Math::max);
                next.merge(Math.abs(difference-rod),shorter+Math.min(difference,rod),Math::max);
            }
            dp=next;
        }
        return dp.get(0);
    }
}
