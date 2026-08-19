class Solution {
    private static final long MOD=1000000007;
    private long power(long base,long exponent){
        long answer=1;
        while(exponent>0){
            if((exponent&1)==1)answer=answer*base%MOD;
            base=base*base%MOD;
            exponent>>=1;
        }
        return answer;
    }
    public int maximumScore(List<Integer> nums,int k){
        int n=nums.size(),maximum=Collections.max(nums);
        int[] primeScore=new int[maximum+1];
        for(int prime=2;prime<=maximum;prime++)if(primeScore[prime]==0)for(int multiple=prime;multiple<=maximum;multiple+=prime)primeScore[multiple]++;
        int[] left=new int[n],right=new int[n];
        Deque<Integer> stack=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            int score=primeScore[nums.get(i)];
            while(!stack.isEmpty()&&primeScore[nums.get(stack.peekLast())]<score)stack.removeLast();
            left[i]=stack.isEmpty()?-1:stack.peekLast();
            stack.addLast(i);
        }
        stack.clear();
        for(int i=n-1;i>=0;i--){
            int score=primeScore[nums.get(i)];
            while(!stack.isEmpty()&&primeScore[nums.get(stack.peekLast())]<=score)stack.removeLast();
            right[i]=stack.isEmpty()?n:stack.peekLast();
            stack.addLast(i);
        }
        Integer[] order=new Integer[n];
        for(int i=0;i<n;i++)order[i]=i;
        Arrays.sort(order,(a,b)->Integer.compare(nums.get(b),nums.get(a)));
        long answer=1,remaining=k;
        for(int index:order){
            long ways=(long)(index-left[index])*(right[index]-index),used=Math.min(remaining,ways);
            answer=answer*power(nums.get(index),used)%MOD;
            remaining-=used;
            if(remaining==0)break;
        }
        return (int)answer;
    }
}
