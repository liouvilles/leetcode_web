class Solution {
    public int numberOfPairs(int[][] points){
        Arrays.sort(points,(first,second)->first[0]!=second[0]?Integer.compare(first[0],second[0]):Integer.compare(second[1],first[1]));
        int answer=0;
        for(int alice=0;alice<points.length;alice++){
            int lowestVisible=Integer.MIN_VALUE;
            for(int bob=alice+1;bob<points.length;bob++)if(points[bob][1]<=points[alice][1]&&points[bob][1]>lowestVisible){
                answer++;
                lowestVisible=points[bob][1];
            }
        }
        return answer;
    }
}
