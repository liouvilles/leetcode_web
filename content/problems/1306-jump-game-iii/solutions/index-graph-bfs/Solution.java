class Solution {
    public boolean canReach(int[] arr,int start){
        Queue<Integer> queue=new ArrayDeque<>();
        boolean[] seen=new boolean[arr.length];
        queue.offer(start);
        seen[start]=true;
        while(!queue.isEmpty()){
            int index=queue.poll();
            if(arr[index]==0)return true;
            int[] next={
                index-arr[index],index+arr[index]
            };
            for(int value:next)if(value>=0&&value<arr.length&&!seen[value]){
                seen[value]=true;
                queue.offer(value);
            }
        }
        return false;
    }
}
