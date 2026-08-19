class Solution {
    public boolean repeatedSubstringPattern(String s){
        int[] prefix=new int[s.length()];
        for(int i=1;i<s.length();i++){
            int j=prefix[i-1];
            while(j>0&&s.charAt(i)!=s.charAt(j))j=prefix[j-1];
            if(s.charAt(i)==s.charAt(j))j++;
            prefix[i]=j;
        }
        int border=prefix[s.length()-1],period=s.length()-border;
        return border>0&&s.length()%period==0;
    }
}
