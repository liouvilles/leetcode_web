class Solution {
    public int maxChunksToSorted(int[] arr){
        int answer=0,maximum=0;
        for(int i=0;i<arr.length;i++){
            maximum=Math.max(maximum,arr[i]);
            if(maximum==i)answer++;
        }
        return answer;
    }
}
