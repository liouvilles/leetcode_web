class Solution {
    fun validateBinaryTreeNodes(n:Int,leftChild:IntArray,rightChild:IntArray):Boolean{
        val degree=IntArray(n);
        for(i in 0 until n)for(child in intArrayOf(leftChild[i],rightChild[i]))if(child!=-1&&++degree[child]>1)return false;
        var root=-1;
        for(i in 0 until n)if(degree[i]==0){
            if(root!=-1)return false;
            root=i
        };
        if(root==-1)return false;
        val queue=java.util.ArrayDeque<Int>();
        val seen=BooleanArray(n);
        queue.add(root);
        seen[root]=true;
        var count=0;
        while(queue.isNotEmpty()){
            val node=queue.removeFirst();
            count++;
            for(child in intArrayOf(leftChild[node],rightChild[node]))if(child!=-1){
                if(seen[child])return false;
                seen[child]=true;
                queue.addLast(child)
            }
        };
        return count==n
    }
}
