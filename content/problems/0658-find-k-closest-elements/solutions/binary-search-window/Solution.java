class Solution {
    public List<Integer> findClosestElements(int[] arr,int k,int x){
        int left=0,right=arr.length-k;
        while(left<right){
            int middle=left+(right-left)/2;
            if(x-arr[middle]>arr[middle+k]-x)left=middle+1;
            else right=middle;
        }
        List<Integer> answer=new ArrayList<>();
        for(int i=left;i<left+k;i++)answer.add(arr[i]);
        return answer;
    }
}
