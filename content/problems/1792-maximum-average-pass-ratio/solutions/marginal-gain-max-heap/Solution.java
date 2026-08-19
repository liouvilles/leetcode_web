class Solution {
    private double gain(double[] c){
        return (c[0]+1)/(c[1]+1)-c[0]/c[1];
    }
    public double maxAverageRatio(int[][] classes,int extraStudents){
        PriorityQueue<double[]> queue=new PriorityQueue<>((a,b)->Double.compare(gain(b),gain(a)));
        for(int[] c:classes)queue.offer(new double[]{
            c[0],c[1]
        });
        while(extraStudents-->0){
            double[] c=queue.poll();
            c[0]++;
            c[1]++;
            queue.offer(c);
        }
        double sum=0;
        for(double[] c:queue)sum+=c[0]/c[1];
        return sum/classes.length;
    }
}
