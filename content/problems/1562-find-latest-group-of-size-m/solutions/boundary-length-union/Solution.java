class Solution {
    public int findLatestStep(int[] arr,int m){
        int[] length=new int[arr.length+2];
        int groups=0,answer=-1;
        for(int step=1;step<=arr.length;step++){
            int position=arr[step-1],left=length[position-1],right=length[position+1];
            if(left==m)groups--;
            if(right==m)groups--;
            int merged=left+right+1;
            length[position-left]=length[position+right]=merged;
            if(merged==m)groups++;
            if(groups>0)answer=step;
        }
        return answer;
    }
}
