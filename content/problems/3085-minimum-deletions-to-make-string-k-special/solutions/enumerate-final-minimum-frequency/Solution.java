class Solution {
    public int minimumDeletions(String word,int k){
        int[] frequency=new int[26];
        for(char letter:word.toCharArray())frequency[letter-'a']++;
        int answer=word.length();
        for(int lower:frequency)if(lower>0){
            int deletions=0;
            for(int count:frequency)if(count>0){
                if(count<lower)deletions+=count;
                else if(count>lower+k)deletions+=count-lower-k;
            }
            answer=Math.min(answer,deletions);
        }
        return answer;
    }
}
