class Solution {
    private int gcd(int a,int b){
        while(b!=0){
            int next=a%b;
            a=b;
            b=next;
        }
        return a;
    }
    public int countBeautifulPairs(int[] nums){
        int[] frequency=new int[10];
        int answer=0;
        for(int value:nums){
            int last=value%10;
            for(int leading=1;leading<=9;leading++)if(gcd(leading,last)==1)answer+=frequency[leading];
            int first=value;
            while(first>=10)first/=10;
            frequency[first]++;
        }
        return answer;
    }
}
