class Solution { fun isRectangleOverlap(rec1:IntArray,rec2:IntArray):Boolean=maxOf(rec1[0],rec2[0])<minOf(rec1[2],rec2[2])&&maxOf(rec1[1],rec2[1])<minOf(rec1[3],rec2[3]) }
