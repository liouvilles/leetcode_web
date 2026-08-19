class Solution {
    public int[] productQueries(int n,int[][] queries){
        List<Long> powers=new ArrayList<>();
        for(int bit=0;bit<31;bit++)if((n&(1<<bit))!=0)powers.add(1L<<bit);
        int[] answer=new int[queries.length];
        long mod=1_000_000_007L;
        for(int q=0;q<queries.length;q++){
            long product=1;
            for(int i=queries[q][0];i<=queries[q][1];i++)product=product*powers.get(i)%mod;
            answer[q]=(int)product;
        }
        return answer;
    }
}
