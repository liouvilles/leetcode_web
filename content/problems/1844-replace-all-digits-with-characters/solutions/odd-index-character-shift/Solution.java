class Solution {
    public String replaceDigits(String text){
        char[] chars=text.toCharArray();
        for(int i=1;i<chars.length;i+=2)chars[i]=(char)(chars[i-1]+chars[i]-'0');
        return new String(chars);
    }
}
