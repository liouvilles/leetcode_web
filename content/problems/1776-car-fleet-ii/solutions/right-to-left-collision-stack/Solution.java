class Solution {
    public double[] getCollisionTimes(int[][] cars){
        int n=cars.length;
        double[] answer=new double[n];
        Arrays.fill(answer,-1);
        Deque<Integer> stack=new ArrayDeque<>();
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty()){
                int next=stack.peekLast();
                if(cars[i][1]<=cars[next][1]){
                    stack.pollLast();
                    continue;
                }
                double time=(double)(cars[next][0]-cars[i][0])/(cars[i][1]-cars[next][1]);
                if(answer[next]<0||time<=answer[next]){
                    answer[i]=time;
                    break;
                }
                stack.pollLast();
            }
            stack.offerLast(i);
        }
        return answer;
    }
}
