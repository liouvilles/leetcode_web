class Solution {
    public int findSpecialInteger(int[] arr){
        for(int start=0;start<arr.length;){
            int end=start+1;
            while(end<arr.length&&arr[end]==arr[start])end++;
            if((end-start)*4>arr.length)return arr[start];
            start=end;
        }
        return -1;
    }
}
