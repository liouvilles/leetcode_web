class Solution {
    private int[][] positions;
    private double distance(double x,double y){
        double answer=0;
        for(int[] point:positions)answer+=Math.hypot(point[0]-x,point[1]-y);
        return answer;
    }
    private double bestAtX(double x){
        double low=0,high=100;
        for(int iteration=0;iteration<80;iteration++){
            double first=(2*low+high)/3,second=(low+2*high)/3;
            if(distance(x,first)<distance(x,second))high=second;
            else low=first;
        }
        return distance(x,(low+high)/2);
    }
    public double getMinDistSum(int[][] positions){
        this.positions=positions;
        double low=0,high=100;
        for(int iteration=0;iteration<80;iteration++){
            double first=(2*low+high)/3,second=(low+2*high)/3;
            if(bestAtX(first)<bestAtX(second))high=second;
            else low=first;
        }
        return bestAtX((low+high)/2);
    }
}
