class Solution {
    fun reversePairs(nums:IntArray):Int{
        val buffer=IntArray(nums.size);
        fun sort(left:Int,right:Int):Int{
            if(left>=right)return 0;
            val middle=(left+right)/2;
            var count=sort(left,middle)+sort(middle+1,right);
            var j=middle+1;
            for(i in left..middle){
                while(j<=right&&nums[i].toLong()>2L*nums[j])j++;
                count+=j-middle-1
            };
            var i=left;
            j=middle+1;
            var k=left;
            while(i<=middle||j<=right)buffer[k++]=if(j>right||(i<=middle&&nums[i]<=nums[j]))nums[i++] else nums[j++];
            for(index in left..right)nums[index]=buffer[index];
            return count
        };
        return sort(0,nums.lastIndex)
    }
}
