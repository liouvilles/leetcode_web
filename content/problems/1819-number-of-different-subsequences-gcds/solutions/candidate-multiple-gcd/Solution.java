class Solution {
    private int gcd(int a,int b){
        return b==0?a:gcd(b,a%b);
    }
    public int countDifferentSubsequenceGCDs(int[] nums){
        int maximum=Arrays.stream(nums).max().getAsInt();
        boolean[] present=new boolean[maximum+1];
        for(int value:nums)present[value]=true;
        int answer=0;
        for(int candidate=1;candidate<=maximum;candidate++){
            int value=0;
            for(int multiple=candidate;multiple<=maximum;multiple+=candidate)if(present[multiple])value=gcd(value,multiple);
            if(value==candidate)answer++;
        }
        return answer;
    }
}
