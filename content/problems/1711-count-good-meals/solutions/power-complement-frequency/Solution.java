class Solution {
    public int countPairs(int[] deliciousness){
        final int MOD=1_000_000_007;
        Map<Integer,Integer> frequency=new HashMap<>();
        long answer=0;
        for(int value:deliciousness){
            for(int power=1;power<=1<<21;power<<=1)answer+=frequency.getOrDefault(power-value,0);
            answer%=MOD;
            frequency.put(value,frequency.getOrDefault(value,0)+1);
        }
        return (int)answer;
    }
}
