class Solution {
    public int visiblePoints(List<List<Integer>> points,int angle,List<Integer> location){
        if(angle>=360)return points.size();
        List<Double> angles=new ArrayList<>();
        int same=0;
        for(List<Integer> point:points){
            int dx=point.get(0)-location.get(0),dy=point.get(1)-location.get(1);
            if(dx==0&&dy==0)same++;
            else angles.add(Math.atan2(dy,dx));
        }
        Collections.sort(angles);
        int original=angles.size();
        for(int i=0;i<original;i++)angles.add(angles.get(i)+2*Math.PI);
        double width=Math.toRadians(angle);
        int left=0,best=0;
        for(int right=0;right<angles.size();right++){
            while(angles.get(right)-angles.get(left)>width+1e-12)left++;
            best=Math.max(best,Math.min(original,right-left+1));
        }
        return best+same;
    }
}
