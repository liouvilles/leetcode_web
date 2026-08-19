class Solution {
    public String shiftingLetters(String s,int[] shifts){
        char[] chars=s.toCharArray();
        long shift=0;
        for(int i=chars.length-1;i>=0;i--){
            shift=(shift+shifts[i])%26;
            chars[i]=(char)('a'+(chars[i]-'a'+shift)%26);
        }
        return new String(chars);
    }
}
