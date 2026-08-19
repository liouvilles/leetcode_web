class Solution {
    public int twoCitySchedCost(int[][] costs){
        Arrays.sort(costs,Comparator.comparingInt(a->a[0]-a[1]));
        int answer=0,n=costs.length/2;
        for(int i=0;i<costs.length;i++)answer+=i<n?costs[i][0]:costs[i][1];
        return answer;
    }
}
