class Solution {
    public boolean checkDistances(String s,int[] distance){
        int[] first=new int[26];
        Arrays.fill(first,-1);
        for(int i=0;i<s.length();i++){
            int letter=s.charAt(i)-'a';
            if(first[letter]<0)first[letter]=i;
            else if(i-first[letter]-1!=distance[letter])return false;
        }
        return true;
    }
}
