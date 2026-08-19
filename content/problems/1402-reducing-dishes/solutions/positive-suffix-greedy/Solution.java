class Solution {
    public int maxSatisfaction(int[] satisfaction){
        Arrays.sort(satisfaction);
        int suffix=0,answer=0;
        for(int i=satisfaction.length-1;i>=0;i--){
            suffix+=satisfaction[i];
            if(suffix<=0)break;
            answer+=suffix;
        }
        return answer;
    }
}
