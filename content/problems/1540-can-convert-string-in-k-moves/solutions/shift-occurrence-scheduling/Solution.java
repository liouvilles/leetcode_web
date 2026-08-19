class Solution {
    public boolean canConvertString(String s,String t,int k){
        if(s.length()!=t.length())return false;
        int[] count=new int[26];
        for(int i=0;i<s.length();i++){
            int difference=(t.charAt(i)-s.charAt(i)+26)%26;
            if(difference==0)continue;
            int scheduled=difference+26*count[difference]++;
            if(scheduled>k)return false;
        }
        return true;
    }
}
