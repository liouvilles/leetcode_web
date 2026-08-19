class Solution {
    public boolean validateBinaryTreeNodes(int n,int[] leftChild,int[] rightChild){
        int[] degree=new int[n];
        for(int i=0;i<n;i++)for(int child:new int[]{
            leftChild[i],rightChild[i]
        })if(child!=-1&&++degree[child]>1)return false;
        int root=-1;
        for(int i=0;i<n;i++)if(degree[i]==0){
            if(root!=-1)return false;
            root=i;
        }
        if(root==-1)return false;
        Queue<Integer> queue=new ArrayDeque<>();
        boolean[] seen=new boolean[n];
        queue.offer(root);
        seen[root]=true;
        int count=0;
        while(!queue.isEmpty()){
            int node=queue.poll();
            count++;
            for(int child:new int[]{
                leftChild[node],rightChild[node]
            })if(child!=-1){
                if(seen[child])return false;
                seen[child]=true;
                queue.offer(child);
            }
        }
        return count==n;
    }
}
