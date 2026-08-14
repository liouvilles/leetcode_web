class Solution { fun construct2DArray(original:IntArray,m:Int,n:Int):Array<IntArray>{if(original.size!=m*n)return emptyArray();return Array(m){row->IntArray(n){col->original[row*n+col]}}} }
