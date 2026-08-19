class Solution {
    private boolean isVowel(char value){
        return value=='a'||value=='e'||value=='i'||value=='o'||value=='u';
    }
    private int period(int value){
        int base=1,remaining=value;
        for(int factor=2;factor*factor<=remaining;factor++){
            int exponent=0;
            while(remaining%factor==0){
                remaining/=factor;
                exponent++;
            }
            for(int count=0;count<(exponent+1)/2;count++)base*=factor;
        }
        if(remaining>1)base*=remaining;
        return 2*base;
    }
    public long beautifulSubstrings(String s,int k){
        int n=s.length(),period=period(k),balance=0;
        Map<Long,Long> frequency=new HashMap<>();
        frequency.put((long)n*period,1L);
        long answer=0;
        for(int position=1;position<=n;position++){
            balance+=isVowel(s.charAt(position-1))?1:-1;
            long key=(long)(balance+n)*period+position%period;
            long previous=frequency.getOrDefault(key,0L);
            answer+=previous;
            frequency.put(key,previous+1);
        }
        return answer;
    }
}
