class Solution {
    public int[] findRightInterval(int[][] intervals){
        int n=intervals.length;
        int[][] starts=new int[n][2];
        for(int i=0;i<n;i++){
            starts[i][0]=intervals[i][0];
            starts[i][1]=i;
        }
        Arrays.sort(starts,Comparator.comparingInt(a->a[0]));
        int[] answer=new int[n];
        for(int i=0;i<n;i++){
            int left=0,right=n;
            while(left<right){
                int middle=(left+right)/2;
                if(starts[middle][0]<intervals[i][1])left=middle+1;
                else right=middle;
            }
            answer[i]=left==n?-1:starts[left][1];
        }
        return answer;
    }
}
