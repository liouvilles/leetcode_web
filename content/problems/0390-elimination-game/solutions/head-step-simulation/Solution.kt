class Solution {
    fun lastRemaining(n:Int):Int{
        var head=1;
        var step=1;
        var remaining=n;
        var left=true;
        while(remaining>1){
            if(left||remaining%2==1)head+=step;
            remaining/=2;
            step*=2;
            left=!left
        };
        return head
    }
}
