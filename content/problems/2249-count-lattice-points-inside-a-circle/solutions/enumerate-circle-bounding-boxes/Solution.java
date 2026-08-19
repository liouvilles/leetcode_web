class Solution {
    public int countLatticePoints(int[][] circles){
        Set<String> points=new HashSet<>();
        for(int[] circle:circles)for(int x=circle[0]-circle[2];x<=circle[0]+circle[2];x++)for(int y=circle[1]-circle[2];y<=circle[1]+circle[2];y++){
            int dx=x-circle[0],dy=y-circle[1];
            if(dx*dx+dy*dy<=circle[2]*circle[2])points.add(x+","+y);
        }
        return points.size();
    }
}
