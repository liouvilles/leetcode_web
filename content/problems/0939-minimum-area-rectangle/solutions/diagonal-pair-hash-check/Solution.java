class Solution {
    public int minAreaRect(int[][] points){
        Set<Long> set=new HashSet<>();
        for(int[] p:points)set.add(key(p[0],p[1]));
        int answer=Integer.MAX_VALUE;
        for(int i=0;i<points.length;i++)for(int j=i+1;j<points.length;j++){
            int[] a=points[i],b=points[j];
            if(a[0]==b[0]||a[1]==b[1])continue;
            if(set.contains(key(a[0],b[1]))&&set.contains(key(b[0],a[1])))answer=Math.min(answer,Math.abs(a[0]-b[0])*Math.abs(a[1]-b[1]));
        }
        return answer==Integer.MAX_VALUE?0:answer;
    }
    private long key(int x,int y){
        return((long)x<<32)^(y&0xffffffffL);
    }
}
