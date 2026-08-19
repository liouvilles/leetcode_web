class Solution {
    fun nextGreaterElement(nums1:IntArray,nums2:IntArray):IntArray{
        val next=hashMapOf<Int,Int>();
        val stack=ArrayDeque<Int>();
        for(value in nums2){
            while(stack.isNotEmpty()&&stack.last()<value)next[stack.removeLast()]=value;
            stack.addLast(value)
        };
        return IntArray(nums1.size){
            next[nums1[it]]?:-1
        }
    }
}
