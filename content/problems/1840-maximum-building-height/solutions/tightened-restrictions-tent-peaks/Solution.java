class Solution {
    public int maxBuilding(int n,int[][] restrictions){
        List<int[]> limits=new ArrayList<>();
        limits.add(new int[]{
            1,0
        });
        for(int[] r:restrictions)limits.add(r.clone());
        limits.add(new int[]{
            n,n-1
        });
        limits.sort(Comparator.comparingInt(a->a[0]));
        for(int i=1;i<limits.size();i++)limits.get(i)[1]=Math.min(limits.get(i)[1],limits.get(i-1)[1]+limits.get(i)[0]-limits.get(i-1)[0]);
        for(int i=limits.size()-2;i>=0;i--)limits.get(i)[1]=Math.min(limits.get(i)[1],limits.get(i+1)[1]+limits.get(i+1)[0]-limits.get(i)[0]);
        int answer=0;
        for(int i=1;i<limits.size();i++){
            int[] a=limits.get(i-1),b=limits.get(i);
            answer=Math.max(answer,(a[1]+b[1]+b[0]-a[0])/2);
        }
        return answer;
    }
}
