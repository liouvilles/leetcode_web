class Solution {
    public boolean areOccurrencesEqual(String s){
        int[] frequency=new int[26];
        for(char letter:s.toCharArray())frequency[letter-'a']++;
        int baseline=0;
        for(int value:frequency)if(value>0){
            if(baseline==0)baseline=value;
            else if(value!=baseline)return false;
        }
        return true;
    }
}
