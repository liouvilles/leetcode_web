class Solution { fun countGoodRectangles(rectangles:Array<IntArray>):Int{val sides=rectangles.map{minOf(it[0],it[1])};val maximum=sides.maxOrNull()!!;return sides.count{it==maximum}} }
