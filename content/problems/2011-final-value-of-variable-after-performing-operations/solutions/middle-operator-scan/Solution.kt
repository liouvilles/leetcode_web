class Solution {
    fun finalValueAfterOperations(operations:Array<String>)=operations.fold(0){value,operation ->
        value+if(operation[1]=='+')1 else -1
    }
}
