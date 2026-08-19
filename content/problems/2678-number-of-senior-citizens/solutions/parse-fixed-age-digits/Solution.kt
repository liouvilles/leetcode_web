class Solution {
    fun countSeniors(details:Array<String>):Int=details.count{
        (it[11]-'0')*10+(it[12]-'0')>60
    }
}
