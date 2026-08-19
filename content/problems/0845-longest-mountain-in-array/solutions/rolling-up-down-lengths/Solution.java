class Solution {
    public int longestMountain(int[] arr){
        int answer=0,up=0,down=0;
        for(int i=1;i<arr.length;i++){
            if(arr[i]==arr[i-1]||down>0&&arr[i]>arr[i-1]){
                up=0;
                down=0;
            }
            if(arr[i]>arr[i-1])up++;
            else if(arr[i]<arr[i-1])down++;
            if(up>0&&down>0)answer=Math.max(answer,up+down+1);
        }
        return answer;
    }
}
