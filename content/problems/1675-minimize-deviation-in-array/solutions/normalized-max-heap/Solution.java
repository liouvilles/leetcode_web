class Solution {
    public int minimumDeviation(int[] nums){
        PriorityQueue<Integer> maximums=new PriorityQueue<>(Collections.reverseOrder());
        int minimum=Integer.MAX_VALUE;
        for(int value:nums){
            if(value%2==1)value*=2;
            maximums.offer(value);
            minimum=Math.min(minimum,value);
        }
        int answer=Integer.MAX_VALUE;
        while(true){
            int maximum=maximums.poll();
            answer=Math.min(answer,maximum-minimum);
            if(maximum%2==1)break;
            maximum/=2;
            minimum=Math.min(minimum,maximum);
            maximums.offer(maximum);
        }
        return answer;
    }
}
