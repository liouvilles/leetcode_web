class Solution {
    public int[] getAverages(int[] nums,int k){
        int[] answer=new int[nums.length];
        Arrays.fill(answer,-1);
        int window=2*k+1;
        if(window>nums.length)return answer;
        long sum=0;
        for(int i=0;i<window;i++)sum+=nums[i];
        for(int center=k;center+k<nums.length;center++){
            answer[center]=(int)(sum/window);
            if(center+k+1<nums.length)sum+=nums[center+k+1]-nums[center-k];
        }
        return answer;
    }
}
