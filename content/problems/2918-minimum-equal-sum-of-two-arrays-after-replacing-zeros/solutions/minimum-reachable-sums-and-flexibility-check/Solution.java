class Solution {
    public long minSum(int[] nums1,int[] nums2){
        long first=0,second=0;
        int zerosFirst=0,zerosSecond=0;
        for(int value:nums1){
            if(value==0){
                first++;
                zerosFirst++;
            }else first+=value;
        }
        for(int value:nums2){
            if(value==0){
                second++;
                zerosSecond++;
            }else second+=value;
        }
        if((first<second&&zerosFirst==0)||(second<first&&zerosSecond==0))return -1;
        return Math.max(first,second);
    }
}
