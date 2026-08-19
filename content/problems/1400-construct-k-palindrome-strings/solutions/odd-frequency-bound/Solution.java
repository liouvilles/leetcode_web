class Solution {
    public boolean canConstruct(String text,int k){
        if(text.length()<k)return false;
        int[] count=new int[26];
        for(char value:text.toCharArray())count[value-'a']++;
        int odd=0;
        for(int frequency:count)odd+=frequency%2;
        return odd<=k;
    }
}
