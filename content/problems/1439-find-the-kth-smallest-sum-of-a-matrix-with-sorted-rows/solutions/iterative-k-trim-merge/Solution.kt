class Solution { fun kthSmallest(mat:Array<IntArray>,k:Int):Int{var sums=listOf(0);for(row in mat)sums=sums.flatMap{sum->row.map{sum+it}}.sorted().take(k);return sums[k-1]} }
