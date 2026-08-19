class Solution {
    public int maximumProduct(int[] nums){
        int first=Integer.MIN_VALUE,second=Integer.MIN_VALUE,third=Integer.MIN_VALUE,low1=Integer.MAX_VALUE,low2=Integer.MAX_VALUE;
        for(int value:nums){
            if(value>=first){
                third=second;
                second=first;
                first=value;
            }else if(value>=second){
                third=second;
                second=value;
            }else if(value>third)third=value;
            if(value<=low1){
                low2=low1;
                low1=value;
            }else if(value<low2)low2=value;
        }
        return(int)Math.max((long)first*second*third,(long)first*low1*low2);
    }
}
