class Solution {
    public int numPairsDivisibleBy60(int[] time){
        int[] frequency=new int[60];
        int answer=0;
        for(int duration:time){
            int remainder=duration%60;
            answer+=frequency[(60-remainder)%60];
            frequency[remainder]++;
        }
        return answer;
    }
}
