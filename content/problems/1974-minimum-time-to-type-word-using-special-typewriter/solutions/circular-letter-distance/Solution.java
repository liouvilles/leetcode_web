class Solution {
    public int minTimeToType(String word){
        int answer=0;
        char current='a';
        for(char target:word.toCharArray()){
            int difference=Math.abs(target-current);
            answer+=Math.min(difference,26-difference)+1;
            current=target;
        }
        return answer;
    }
}
