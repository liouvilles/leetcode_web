class Solution {
    private String digits;
    private int divisor;
    private Map<Long,Integer> memo;
    private long key(int pos,int balance,int remainder,boolean started){
        long key=pos;
        key=key*(2*digits.length()+1)+balance+digits.length();
        key=key*divisor+remainder;
        return key*2+(started?1:0);
    }
    private int dfs(int pos,int balance,int remainder,boolean started,boolean tight){
        if(pos==digits.length())return started&&balance==0&&remainder==0?1:0;
        long state=key(pos,balance,remainder,started);
        if(!tight&&memo.containsKey(state))return memo.get(state);
        int limit=tight?digits.charAt(pos)-'0':9,ways=0;
        for(int digit=0;digit<=limit;digit++){
            boolean nextStarted=started||digit!=0;
            int nextBalance=balance,nextRemainder=remainder;
            if(nextStarted){
                nextBalance+=digit%2==0?1:-1;
                nextRemainder=(remainder*10+digit)%divisor;
            }
            ways+=dfs(pos+1,nextBalance,nextRemainder,nextStarted,tight&&digit==limit);
        }
        if(!tight)memo.put(state,ways);
        return ways;
    }
    private int countUpTo(int bound){
        if(bound<=0)return 0;
        digits=Integer.toString(bound);
        memo=new HashMap<>();
        return dfs(0,0,0,false,true);
    }
    public int numberOfBeautifulIntegers(int low,int high,int k){
        divisor=k;
        return countUpTo(high)-countUpTo(low-1);
    }
}
