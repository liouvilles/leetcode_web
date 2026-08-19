class Solution {
    public:int maximumGroups(vector<int>& grades){
        int groups=0,used=0;
        while(used+groups+1<=(int)grades.size()){
            ++groups;
            used+=groups;
        }
        return groups;
    }
};
