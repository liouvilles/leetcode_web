class Solution {
    public List<Integer> filterRestaurants(int[][] restaurants,int veganFriendly,int maxPrice,int maxDistance){
        List<int[]> filtered=new ArrayList<>();
        for(int[] restaurant:restaurants)if((veganFriendly==0||restaurant[2]==1)&&restaurant[3]<=maxPrice&&restaurant[4]<=maxDistance)filtered.add(restaurant);
        filtered.sort((a,b)->a[1]!=b[1]?Integer.compare(b[1],a[1]):Integer.compare(b[0],a[0]));
        List<Integer> answer=new ArrayList<>();
        for(int[] restaurant:filtered)answer.add(restaurant[0]);
        return answer;
    }
}
