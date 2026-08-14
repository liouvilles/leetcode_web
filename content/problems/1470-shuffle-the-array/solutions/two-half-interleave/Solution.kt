class Solution { fun shuffle(nums:IntArray,n:Int):IntArray=IntArray(2*n){index->if(index%2==0)nums[index/2]else nums[n+index/2]} }
