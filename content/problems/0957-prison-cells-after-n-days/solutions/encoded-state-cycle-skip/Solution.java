class Solution {
    public int[] prisonAfterNDays(int[] cells,int n){
        Map<Integer,Integer> seen=new HashMap<>();
        while(n>0){
            int state=encode(cells);
            if(seen.containsKey(state))n%=seen.get(state)-n;
            else seen.put(state,n);
            if(n>0){
                n--;
                int[] next=new int[8];
                for(int i=1;i<7;i++)next[i]=cells[i-1]==cells[i+1]?1:0;
                cells=next;
            }
        }
        return cells;
    }
    private int encode(int[] cells){
        int state=0;
        for(int bit:cells)state=state*2+bit;
        return state;
    }
}
