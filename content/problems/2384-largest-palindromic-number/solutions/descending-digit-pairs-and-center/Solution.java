class Solution {
    public String largestPalindromic(String num){
        int[] count=new int[10];
        for(char ch:num.toCharArray())count[ch-'0']++;
        StringBuilder left=new StringBuilder();
        for(int digit=9;digit>=0;digit--){
            int pairs=count[digit]/2;
            if(digit==0&&left.length()==0)continue;
            for(int i=0;i<pairs;i++)left.append(digit);
            count[digit]-=pairs*2;
        }
        char center=0;
        for(int digit=9;digit>=0;digit--)if(count[digit]>0){
            center=(char)('0'+digit);
            break;
        }
        StringBuilder answer=new StringBuilder(left);
        if(center!=0)answer.append(center);
        answer.append(new StringBuilder(left).reverse());
        return answer.length()==0?"0":answer.toString();
    }
}
