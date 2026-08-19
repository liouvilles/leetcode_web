class Solution {
    public int numTeams(int[] rating){
        int answer=0;
        for(int middle=0;middle<rating.length;middle++){
            int lessLeft=0,greaterLeft=0,lessRight=0,greaterRight=0;
            for(int left=0;left<middle;left++)if(rating[left]<rating[middle])lessLeft++;
            else greaterLeft++;
            for(int right=middle+1;right<rating.length;right++)if(rating[right]<rating[middle])lessRight++;
            else greaterRight++;
            answer+=lessLeft*greaterRight+greaterLeft*lessRight;
        }
        return answer;
    }
}
