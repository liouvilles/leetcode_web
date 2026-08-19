class Solution {
    public int longestSubsequence(String s,int k){
        long value=0,power=1;
        int length=0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)=='0')length++;
            else if(value+power<=k){
                value+=power;
                length++;
            }
            if(power<=k)power*=2;
        }
        return length;
    }
}
