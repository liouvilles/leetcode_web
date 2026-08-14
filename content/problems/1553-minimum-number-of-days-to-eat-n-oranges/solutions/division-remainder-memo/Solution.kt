class Solution { private val memo=mutableMapOf<Int,Int>();fun minDays(n:Int):Int{if(n<=1)return n;return memo.getOrPut(n){1+minOf(n%2+minDays(n/2),n%3+minDays(n/3))}} }
