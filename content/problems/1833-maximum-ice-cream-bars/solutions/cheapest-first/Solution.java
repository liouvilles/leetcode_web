class Solution {
    public int maxIceCream(int[] costs,int coins){
        Arrays.sort(costs);
        int answer=0;
        for(int cost:costs){
            if(coins<cost)break;
            coins-=cost;
            answer++;
        }
        return answer;
    }
}
