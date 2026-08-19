class Solution {
    public int similarPairs(String[] words){
        Map<Integer,Integer> frequency=new HashMap<>();
        int answer=0;
        for(String word:words){
            int mask=0;
            for(char character:word.toCharArray())mask|=1<<(character-'a');
            answer+=frequency.getOrDefault(mask,0);
            frequency.merge(mask,1,Integer::sum);
        }
        return answer;
    }
}
