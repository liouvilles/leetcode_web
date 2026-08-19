class Solution {
    public int primePalindrome(int n){
        if(n>=8&&n<=11)return 11;
        for(int prefix=1;;prefix++){
            String text=Integer.toString(prefix);
            StringBuilder palindrome=new StringBuilder(text);
            for(int i=text.length()-2;i>=0;i--)palindrome.append(text.charAt(i));
            int value=Integer.parseInt(palindrome.toString());
            if(value>=n&&prime(value))return value;
        }
    }
    private boolean prime(int value){
        if(value<2)return false;
        for(int divisor=2;(long)divisor*divisor<=value;divisor++)if(value%divisor==0)return false;
        return true;
    }
}
