class Solution {
    public String smallestString(String s){
        char[] chars=s.toCharArray();
        int index=0;
        while(index<chars.length&&chars[index]=='a')index++;
        if(index==chars.length)chars[chars.length-1]='z';
        else while(index<chars.length&&chars[index]!='a'){
            chars[index]--;
            index++;
        }
        return new String(chars);
    }
}
