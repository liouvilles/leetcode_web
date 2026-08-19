class Solution {
    private int lowerBound(int[] values,int target){
        int left=0,right=values.length;
        while(left<right){
            int middle=left+(right-left)/2;
            if(values[middle]<target)left=middle+1;
            else right=middle;
        }
        return left;
    }
    public int findTheDistanceValue(int[] arr1,int[] arr2,int d){
        Arrays.sort(arr2);
        int answer=0;
        for(int value:arr1){
            int index=lowerBound(arr2,value);
            boolean close=index<arr2.length&&Math.abs(arr2[index]-value)<=d||index>0&&Math.abs(arr2[index-1]-value)<=d;
            if(!close)answer++;
        }
        return answer;
    }
}
