class Solution {
    public int appendCharacters(String s,String t){
        int matched=0;
        for(int i=0;i<s.length()&&matched<t.length();i++)if(s.charAt(i)==t.charAt(matched))matched++;
        return t.length()-matched;
    }
}
