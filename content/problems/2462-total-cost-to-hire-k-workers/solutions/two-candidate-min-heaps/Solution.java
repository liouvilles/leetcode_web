class Solution {
    private int compare(int[] a,int[] b){
        return a[0]!=b[0]?Integer.compare(a[0],b[0]):Integer.compare(a[1],b[1]);
    }
    public long totalCost(int[] costs,int k,int candidates){
        PriorityQueue<int[]> leftHeap=new PriorityQueue<>(this::compare),rightHeap=new PriorityQueue<>(this::compare);
        int left=0,right=costs.length-1;
        while(left<=right&&leftHeap.size()<candidates){
            leftHeap.offer(new int[]{
                costs[left],left
            });
            left++;
        }while(left<=right&&rightHeap.size()<candidates){
            rightHeap.offer(new int[]{
                costs[right],right
            });
            right--;
        }
        long answer=0;
        while(k-->0){
            boolean takeLeft=rightHeap.isEmpty()||!leftHeap.isEmpty()&&compare(leftHeap.peek(),rightHeap.peek())<=0;
            int[] chosen=takeLeft?leftHeap.poll():rightHeap.poll();
            answer+=chosen[0];
            if(left<=right){
                if(takeLeft){
                    leftHeap.offer(new int[]{
                        costs[left],left
                    });
                    left++;
                }else{
                    rightHeap.offer(new int[]{
                        costs[right],right
                    });
                    right--;
                }
            }
        }
        return answer;
    }
}
