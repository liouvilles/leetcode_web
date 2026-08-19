class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr,int k){
        PriorityQueue<int[]> heap=new PriorityQueue<>((a,b)->Long.compare((long)arr[a[0]]*arr[b[1]],(long)arr[b[0]]*arr[a[1]]));
        for(int j=1;j<arr.length;j++)heap.offer(new int[]{
            0,j
        });
        int[] current=null;
        while(k-->0){
            current=heap.poll();
            if(current[0]+1<current[1])heap.offer(new int[]{
                current[0]+1,current[1]
            });
        }
        return new int[]{
            arr[current[0]],arr[current[1]]
        };
    }
}
