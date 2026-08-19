class Solution {
    public int longestStrChain(String[] words){
        Arrays.sort(words,Comparator.comparingInt(String::length));
        Map<String,Integer> best=new HashMap<>();
        int answer=1;
        for(String word:words){
            int length=1;
            for(int i=0;i<word.length();i++){
                String predecessor=word.substring(0,i)+word.substring(i+1);
                length=Math.max(length,best.getOrDefault(predecessor,0)+1);
            }
            best.put(word,length);
            answer=Math.max(answer,length);
        }
        return answer;
    }
}
