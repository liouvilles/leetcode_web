class Solution {
    public int maximumBags(int[] capacity,int[] rocks,int additionalRocks){
        int[] deficits=new int[capacity.length];
        for(int i=0;i<capacity.length;i++)deficits[i]=capacity[i]-rocks[i];
        Arrays.sort(deficits);
        int answer=0;
        for(int deficit:deficits){
            if(deficit>additionalRocks)break;
            additionalRocks-=deficit;
            answer++;
        }
        return answer;
    }
}
