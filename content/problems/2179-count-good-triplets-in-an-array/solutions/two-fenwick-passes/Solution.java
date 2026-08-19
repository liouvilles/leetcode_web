class Solution {
    static class Fenwick{
        long[] tree;
        Fenwick(int n){
            tree=new long[n+1];
        }
        void add(int index){
            for(index++;index<tree.length;index+=index&-index)tree[index]++;
        }
        long sum(int index){
            long value=0;
            for(index++;index>0;index-=index&-index)value+=tree[index];
            return value;
        }
    }
    public long goodTriplets(int[] nums1,int[] nums2){
        int n=nums1.length;
        int[] position=new int[n],mapped=new int[n];
        for(int i=0;i<n;i++)position[nums2[i]]=i;
        for(int i=0;i<n;i++)mapped[i]=position[nums1[i]];
        long[] left=new long[n];
        Fenwick bit=new Fenwick(n);
        for(int i=0;i<n;i++){
            left[i]=mapped[i]==0?0:bit.sum(mapped[i]-1);
            bit.add(mapped[i]);
        }
        bit=new Fenwick(n);
        long answer=0;
        for(int i=n-1;i>=0;i--){
            long notGreater=bit.sum(mapped[i]);
            long greater=(n-1-i)-notGreater;
            answer+=left[i]*greater;
            bit.add(mapped[i]);
        }
        return answer;
    }
}
