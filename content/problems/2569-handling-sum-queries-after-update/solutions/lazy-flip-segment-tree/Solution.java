class Solution {
    private int[] tree;
    private boolean[] lazy;
    private void build(int node,int left,int right,int[] nums){
        if(left==right){
            tree[node]=nums[left];
            return;
        }
        int middle=(left+right)/2;
        build(node*2,left,middle,nums);
        build(node*2+1,middle+1,right,nums);
        tree[node]=tree[node*2]+tree[node*2+1];
    }
    private void flip(int node,int left,int right){
        tree[node]=right-left+1-tree[node];
        lazy[node]=!lazy[node];
    }
    private void push(int node,int left,int right){
        if(!lazy[node]||left==right)return;
        int middle=(left+right)/2;
        flip(node*2,left,middle);
        flip(node*2+1,middle+1,right);
        lazy[node]=false;
    }
    private void update(int node,int left,int right,int ql,int qr){
        if(ql<=left&&right<=qr){
            flip(node,left,right);
            return;
        }
        push(node,left,right);
        int middle=(left+right)/2;
        if(ql<=middle)update(node*2,left,middle,ql,qr);
        if(qr>middle)update(node*2+1,middle+1,right,ql,qr);
        tree[node]=tree[node*2]+tree[node*2+1];
    }
    public long[] handleQuery(int[] nums1,int[] nums2,int[][] queries){
        int n=nums1.length;
        tree=new int[4*n];
        lazy=new boolean[4*n];
        build(1,0,n-1,nums1);
        long sum=0;
        for(int value:nums2)sum+=value;
        List<Long> reports=new ArrayList<>();
        for(int[] query:queries){
            if(query[0]==1)update(1,0,n-1,query[1],query[2]);
            else if(query[0]==2)sum+=(long)query[1]*tree[1];
            else reports.add(sum);
        }
        long[] answer=new long[reports.size()];
        for(int i=0;i<answer.length;i++)answer[i]=reports.get(i);
        return answer;
    }
}
