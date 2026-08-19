class Solution {
    public int countWays(List<Integer> nums){
        List<Integer> sorted=new ArrayList<>(nums);
        Collections.sort(sorted);
        int answer=0,n=sorted.size();
        for(int selected=0;selected<=n;selected++)if((selected==0||sorted.get(selected-1)<selected)&&(selected==n||sorted.get(selected)>selected))answer++;
        return answer;
    }
}
