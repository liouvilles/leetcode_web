class Solution {
    private int lowerBound(int[] a,int size,int target){
        int left=0,right=size;
        while(left<right){
            int middle=(left+right)/2;
            if(a[middle]<target)left=middle+1;
            else right=middle;
        }
        return left;
    }
    private int upperBound(int[] a,int size,int target){
        int left=0,right=size;
        while(left<right){
            int middle=(left+right)/2;
            if(a[middle]<=target)left=middle+1;
            else right=middle;
        }
        return left;
    }
    public long numberOfPairs(int[] nums1,int[] nums2,int diff){
        int n=nums1.length;
        int[] values=new int[n],coordinates=new int[n];
        for(int i=0;i<n;i++)values[i]=coordinates[i]=nums1[i]-nums2[i];
        Arrays.sort(coordinates);
        int size=0;
        for(int value:coordinates)if(size==0||coordinates[size-1]!=value)coordinates[size++]=value;
        int[] tree=new int[size+1];
        long answer=0;
        for(int value:values){
            for(int index=upperBound(coordinates,size,value+diff);index>0;index-=index&-index)answer+=tree[index];
            for(int index=lowerBound(coordinates,size,value)+1;index<=size;index+=index&-index)tree[index]++;
        }
        return answer;
    }
}
