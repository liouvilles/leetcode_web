class Solution {
    fun minAddToMakeValid(s:String):Int{
        var balance=0;
        var added=0;
        for(ch in s)if(ch=='(')balance++ else if(balance>0)balance-- else added++;
        return added+balance
    }
}
