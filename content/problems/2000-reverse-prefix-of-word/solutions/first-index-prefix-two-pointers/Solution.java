class Solution {
    public String reversePrefix(String word,char ch){
        int right=word.indexOf(ch);
        if(right<0)return word;
        char[] value=word.toCharArray();
        for(int left=0;left<right;left++,right--){
            char temporary=value[left];
            value[left]=value[right];
            value[right]=temporary;
        }
        return new String(value);
    }
}
