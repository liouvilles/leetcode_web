class Solution {
    public int minimumPartition(String s,int k){
        int parts=1;
        long current=0;
        for(char character:s.toCharArray()){
            int digit=character-'0';
            if(digit>k)return -1;
            if(current*10+digit>k){
                parts++;
                current=digit;
            }else current=current*10+digit;
        }
        return parts;
    }
}
