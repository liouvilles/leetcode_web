class Solution { fun flowerGame(n:Int,m:Int):Long{val oddN=(n.toLong()+1)/2;val evenN=n.toLong()/2;val oddM=(m.toLong()+1)/2;val evenM=m.toLong()/2;return oddN*evenM+evenN*oddM} }
