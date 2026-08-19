class Solution {
    fun minimumBoxes(apple:IntArray,capacity:IntArray):Int{
        var remaining=apple.sum()
        capacity.sort()
        for(index in capacity.lastIndex downTo 0){
            remaining-=capacity[index]
            if(remaining<=0)return capacity.size-index
        }
        return capacity.size
    }
}
