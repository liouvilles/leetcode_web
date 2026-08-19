class Solution { fun sortTheStudents(score:Array<IntArray>,k:Int):Array<IntArray>{score.sortByDescending{it[k]};return score} }
