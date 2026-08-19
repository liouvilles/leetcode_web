class Solution {
    private int countSegment(String word,int start,int end,int k){
        int answer=0,length=end-start;
        for(int kinds=1;kinds<=26&&kinds*k<=length;kinds++){
            int window=kinds*k,distinct=0,exact=0;
            int[] frequency=new int[26];
            for(int right=start;right<end;right++){
                int added=word.charAt(right)-'a';
                if(frequency[added]==0)distinct++;
                if(frequency[added]==k)exact--;
                frequency[added]++;
                if(frequency[added]==k)exact++;
                if(right-start>=window){
                    int removed=word.charAt(right-window)-'a';
                    if(frequency[removed]==k)exact--;
                    frequency[removed]--;
                    if(frequency[removed]==k)exact++;
                    if(frequency[removed]==0)distinct--;
                }
                if(right-start+1>=window&&distinct==kinds&&exact==kinds)answer++;
            }
        }
        return answer;
    }
    public int countCompleteSubstrings(String word,int k){
        int answer=0,start=0;
        for(int end=1;end<=word.length();end++)if(end==word.length()||Math.abs(word.charAt(end)-word.charAt(end-1))>2){
            answer+=countSegment(word,start,end,k);
            start=end;
        }
        return answer;
    }
}
