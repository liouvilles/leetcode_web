class Solution {
    public int shipWithinDays(int[] weights,int days){
        int left=0,right=0;
        for(int weight:weights){
            left=Math.max(left,weight);
            right+=weight;
        }while(left<right){
            int capacity=left+(right-left)/2,needed=1,load=0;
            for(int weight:weights){
                if(load+weight>capacity){
                    needed++;
                    load=0;
                }
                load+=weight;
            }
            if(needed<=days)right=capacity;
            else left=capacity+1;
        }
        return left;
    }
}
