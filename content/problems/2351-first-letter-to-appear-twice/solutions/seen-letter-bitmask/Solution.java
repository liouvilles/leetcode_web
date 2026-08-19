class Solution {
    public char repeatedCharacter(String s){
        int mask=0;
        for(char ch:s.toCharArray()){
            int bit=1<<(ch-'a');
            if((mask&bit)!=0)return ch;
            mask|=bit;
        }
        throw new IllegalArgumentException();
    }
}
