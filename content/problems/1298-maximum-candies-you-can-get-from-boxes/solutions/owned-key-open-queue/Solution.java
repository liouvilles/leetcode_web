class Solution {
    public int maxCandies(int[] status,int[] candies,int[][] keys,int[][] containedBoxes,int[] initialBoxes){
        int n=status.length,total=0;
        boolean[] owned=new boolean[n],hasKey=new boolean[n],opened=new boolean[n];
        Queue<Integer> queue=new ArrayDeque<>();
        for(int box:initialBoxes){
            owned[box]=true;
            queue.offer(box);
        }while(!queue.isEmpty()){
            int box=queue.poll();
            if(opened[box]||!owned[box]||status[box]==0&&!hasKey[box])continue;
            opened[box]=true;
            total+=candies[box];
            for(int key:keys[box]){
                hasKey[key]=true;
                if(owned[key])queue.offer(key);
            }
            for(int child:containedBoxes[box]){
                owned[child]=true;
                queue.offer(child);
            }
        }
        return total;
    }
}
