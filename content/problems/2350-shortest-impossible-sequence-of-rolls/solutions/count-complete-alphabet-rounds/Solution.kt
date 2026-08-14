class Solution { fun shortestSequence(rolls:IntArray,k:Int):Int{val seen=HashSet<Int>();var rounds=0;for(roll in rolls){seen.add(roll);if(seen.size==k){rounds++;seen.clear()}};return rounds+1} }
