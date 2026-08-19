class Solution {
    public String shortestPalindrome(String s){
        String reversed=new StringBuilder(s).reverse().toString(),combined=s+"#"+reversed;
        int[] prefix=new int[combined.length()];
        for(int i=1;i<combined.length();i++){
            int j=prefix[i-1];
            while(j>0&&combined.charAt(i)!=combined.charAt(j))j=prefix[j-1];
            if(combined.charAt(i)==combined.charAt(j))j++;
            prefix[i]=j;
        }
        int length=prefix[combined.length()-1];
        return reversed.substring(0,s.length()-length)+s;
    }
}
