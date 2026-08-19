class Solution {
    fun maxTurbulenceSize(arr:IntArray):Int{
        var up=1;
        var down=1;
        var answer=1;
        for(i in 1 until arr.size){
            if(arr[i]>arr[i-1]){
                up=down+1;
                down=1
            }else if(arr[i]<arr[i-1]){
                down=up+1;
                up=1
            }else{
                up=1;
                down=1
            };
            answer=maxOf(answer,up,down)
        };
        return answer
    }
}
