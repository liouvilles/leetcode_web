class Solution {
    public int largestOverlap(int[][] img1,int[][] img2){
        List<int[]> first=new ArrayList<>(),second=new ArrayList<>();
        for(int r=0;r<img1.length;r++)for(int c=0;c<img1.length;c++){
            if(img1[r][c]==1)first.add(new int[]{
                r,c
            });
            if(img2[r][c]==1)second.add(new int[]{
                r,c
            });
        }
        Map<String,Integer> counts=new HashMap<>();
        int answer=0;
        for(int[] a:first)for(int[] b:second){
            String key=(a[0]-b[0])+","+(a[1]-b[1]);
            int count=counts.merge(key,1,Integer::sum);
            answer=Math.max(answer,count);
        }
        return answer;
    }
}
