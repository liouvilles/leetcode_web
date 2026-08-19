class Solution {
    fun findInMountainArray(target:Int,mountainArr:MountainArray):Int{
        var left=0;
        var right=mountainArr.length()-1;
        while(left<right){
            val middle=(left+right)/2;
            if(mountainArr.get(middle)<mountainArr.get(middle+1))left=middle+1 else right=middle
        };
        fun search(start:Int,end:Int,ascending:Boolean):Int{
            var low=start;
            var high=end;
            while(low<=high){
                val middle=(low+high)/2;
                val value=mountainArr.get(middle);
                if(value==target)return middle;
                if((value<target)==ascending)low=middle+1 else high=middle-1
            };
            return -1
        };
        val found=search(0,left,true);
        return if(found>=0)found else search(left+1,mountainArr.length()-1,false)
    }
}
