class Solution {
    public int nearestValidPoint(int x,int y,int[][] points){
        int answer=-1,best=Integer.MAX_VALUE;
        for(int i=0;i<points.length;i++)if(points[i][0]==x||points[i][1]==y){
            int distance=Math.abs(points[i][0]-x)+Math.abs(points[i][1]-y);
            if(distance<best){
                best=distance;
                answer=i;
            }
        }
        return answer;
    }
}
