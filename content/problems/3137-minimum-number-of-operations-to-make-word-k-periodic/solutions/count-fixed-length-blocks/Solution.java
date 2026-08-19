class Solution {
    public int minimumOperationsToMakeKPeriodic(String word,int k){
        Map<String,Integer> frequency=new HashMap<>();
        int maximum=0;
        for(int start=0;start<word.length();start+=k){
            String block=word.substring(start,start+k);
            int count=frequency.merge(block,1,Integer::sum);
            maximum=Math.max(maximum,count);
        }
        return word.length()/k-maximum;
    }
}
