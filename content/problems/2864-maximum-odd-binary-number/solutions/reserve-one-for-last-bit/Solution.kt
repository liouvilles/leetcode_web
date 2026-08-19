class Solution { fun maximumOddBinaryNumber(s:String):String{val ones=s.count{it=='1'};return "1".repeat(ones-1)+"0".repeat(s.length-ones)+"1"} }
