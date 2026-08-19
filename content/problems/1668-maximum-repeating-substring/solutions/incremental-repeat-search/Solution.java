class Solution {
    public int maxRepeating(String sequence,String word){
        String candidate=word;
        int answer=0;
        while(sequence.contains(candidate)){
            answer++;
            candidate+=word;
        }
        return answer;
    }
}
