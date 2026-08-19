class Solution {
    fun calculateTax(brackets:Array<IntArray>,income:Int):Double{
        var tax=0.0;
        var previous=0;
        for(bracket in brackets){
            val taxable=maxOf(0,minOf(income,bracket[0])-previous);
            tax+=taxable*bracket[1]/100.0;
            if(income<=bracket[0])break;
            previous=bracket[0]
        };
        return tax
    }
}
