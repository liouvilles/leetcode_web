class Solution {
    public String makeSmallestPalindrome(String s){
        char[] value=s.toCharArray();
        for(int left=0,right=value.length-1;left<right;left++,right--){
            char smaller=(char)Math.min(value[left],value[right]);
            value[left]=value[right]=smaller;
        }
        return new String(value);
    }
}
