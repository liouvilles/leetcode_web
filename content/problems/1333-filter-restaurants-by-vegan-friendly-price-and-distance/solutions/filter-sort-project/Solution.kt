class Solution {
    fun filterRestaurants(restaurants:Array<IntArray>,veganFriendly:Int,maxPrice:Int,maxDistance:Int):List<Int>{
        return restaurants.filter{
            (veganFriendly==0||it[2]==1)&&it[3]<=maxPrice&&it[4]<=maxDistance
        }.sortedWith(compareByDescending<IntArray>{
            it[1]
        }.thenByDescending{
            it[0]
        }).map{
            it[0]
        }
    }
}
