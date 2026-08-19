class Solution {
    public String modifyString(String text){
        char[] chars=text.toCharArray();
        for(int i=0;i<chars.length;i++)if(chars[i]=='?')for(char value='a';value<='c';value++)if((i==0||chars[i-1]!=value)&&(i+1==chars.length||chars[i+1]!=value)){
            chars[i]=value;
            break;
        }
        return new String(chars);
    }
}
