class Solution {
    fun minimumRefill(plants:IntArray,capacityA:Int,capacityB:Int):Int{
        var left=0;
        var right=plants.lastIndex;
        var alice=capacityA;
        var bob=capacityB;
        var answer=0;
        while(left<right){
            if(alice<plants[left]){
                answer++;
                alice=capacityA
            };
            alice-=plants[left++];
            if(bob<plants[right]){
                answer++;
                bob=capacityB
            };
            bob-=plants[right--]
        };
        if(left==right&&maxOf(alice,bob)<plants[left])answer++;
        return answer
    }
}
