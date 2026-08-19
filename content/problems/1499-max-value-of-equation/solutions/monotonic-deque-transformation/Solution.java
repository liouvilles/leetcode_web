class Solution {
    public int findMaxValueOfEquation(int[][] points,int k){
        Deque<Integer> deque=new ArrayDeque<>();
        int answer=Integer.MIN_VALUE;
        for(int j=0;j<points.length;j++){
            while(!deque.isEmpty()&&points[j][0]-points[deque.peekFirst()][0]>k)deque.removeFirst();
            if(!deque.isEmpty()){
                int i=deque.peekFirst();
                answer=Math.max(answer,points[j][1]+points[j][0]+points[i][1]-points[i][0]);
            }
            int value=points[j][1]-points[j][0];
            while(!deque.isEmpty()&&points[deque.peekLast()][1]-points[deque.peekLast()][0]<=value)deque.removeLast();
            deque.addLast(j);
        }
        return answer;
    }
}
