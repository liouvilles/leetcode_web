class Solution {
    public int minimumTimeToInitialState(String word,int k){
        int n=word.length();
        for(int shift=k;shift<n;shift+=k){
            boolean same=true;
            for(int index=shift;index<n;index++)if(word.charAt(index)!=word.charAt(index-shift)){
                same=false;
                break;
            }
            if(same)return shift/k;
        }
        return (n+k-1)/k;
    }
}
