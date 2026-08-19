class Solution {
    public int flipLights(int n,int presses){
        Set<Integer> states=new HashSet<>();
        int lamps=Math.min(n,6);
        for(int mask=0;mask<16;mask++){
            int used=Integer.bitCount(mask);
            if(used>presses||((presses-used)&1)!=0)continue;
            int state=0;
            for(int index=1;index<=lamps;index++){
                boolean on=true;
                if((mask&1)!=0)on=!on;
                if((mask&2)!=0&&index%2==0)on=!on;
                if((mask&4)!=0&&index%2==1)on=!on;
                if((mask&8)!=0&&(index-1)%3==0)on=!on;
                if(on)state|=1<<(index-1);
            }
            states.add(state);
        }
        return states.size();
    }
}
