class Solution {
    fun findDiagonalOrder(nums:List<List<Int>>):IntArray{
        val diagonals=mutableListOf<MutableList<Int>>();
        var size=0;
        for(row in nums.indices)for(col in nums[row].indices){
            while(diagonals.size<=row+col)diagonals.add(mutableListOf());
            diagonals[row+col].add(nums[row][col]);
            size++
        };
        val answer=IntArray(size);
        var index=0;
        for(diagonal in diagonals)for(i in diagonal.lastIndex downTo 0)answer[index++]=diagonal[i];
        return answer
    }
}
