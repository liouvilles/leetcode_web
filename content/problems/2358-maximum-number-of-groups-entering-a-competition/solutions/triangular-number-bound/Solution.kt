class Solution { fun maximumGroups(grades:IntArray):Int{var groups=0;var used=0;while(used+groups+1<=grades.size){groups++;used+=groups};return groups} }
