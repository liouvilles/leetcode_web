class Solution {
    fun distMoney(moneyInput:Int,childrenInput:Int):Int{
        var money=moneyInput-childrenInput;
        if(money<0)return -1;
        var children=childrenInput;
        var full=minOf(money/7,children);
        money-=full*7;
        children-=full;
        if(children==0&&money>0)full-- else if(children==1&&money==3)full--;
        return full
    }
}
