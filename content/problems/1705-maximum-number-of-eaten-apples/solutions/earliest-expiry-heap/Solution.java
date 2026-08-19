class Solution {
    public int eatenApples(int[] apples,int[] days){
        PriorityQueue<int[]> batches=new PriorityQueue<>(Comparator.comparingInt(batch->batch[0]));
        int eaten=0;
        for(int day=0;day<apples.length||!batches.isEmpty();day++){
            if(day<apples.length&&apples[day]>0)batches.offer(new int[]{
                day+days[day],apples[day]
            });
            while(!batches.isEmpty()&&batches.peek()[0]<=day)batches.poll();
            if(!batches.isEmpty()){
                int[] batch=batches.peek();
                batch[1]--;
                eaten++;
                if(batch[1]==0)batches.poll();
            }
        }
        return eaten;
    }
}
