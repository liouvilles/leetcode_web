class Solution {
    fun longestMountain(arr:IntArray):Int{
        var answer=0;
        var up=0;
        var down=0;
        for(i in 1 until arr.size){
            if(arr[i]==arr[i-1]||down>0&&arr[i]>arr[i-1]){
                up=0;
                down=0
            };
            if(arr[i]>arr[i-1])up++ else if(arr[i]<arr[i-1])down++;
            if(up>0&&down>0)answer=maxOf(answer,up+down+1)
        };
        return answer
    }
}
