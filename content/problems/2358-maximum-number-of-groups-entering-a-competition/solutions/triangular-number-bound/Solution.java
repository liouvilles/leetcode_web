class Solution {
    public int maximumGroups(int[] grades){
        int groups=0,used=0;
        while(used+groups+1<=grades.length){
            groups++;
            used+=groups;
        }
        return groups;
    }
}
