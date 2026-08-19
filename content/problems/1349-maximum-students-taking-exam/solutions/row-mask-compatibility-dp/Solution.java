class Solution {
    public int maxStudents(char[][] seats){
        int columns=seats[0].length;
        Map<Integer,Integer> dp=new HashMap<>();
        dp.put(0,0);
        for(char[] row:seats){
            int available=0;
            for(int c=0;c<columns;c++)if(row[c]=='.')available|=1<<c;
            Map<Integer,Integer> next=new HashMap<>();
            for(int mask=0;mask<(1<<columns);mask++)if((mask&~available)==0&&(mask&(mask<<1))==0)for(Map.Entry<Integer,Integer> state:dp.entrySet()){
                int previous=state.getKey();
                if((mask&(previous<<1))==0&&(mask&(previous>>1))==0)next.put(mask,Math.max(next.getOrDefault(mask,0),state.getValue()+Integer.bitCount(mask)));
            }
            dp=next;
        }
        return Collections.max(dp.values());
    }
}
