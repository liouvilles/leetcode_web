class Solution {
    public:long long dividePlayers(vector<int>& skill){
        sort(skill.begin(),skill.end());
        int target=skill.front()+skill.back();
        long long chemistry=0;
        for(int left=0,right=skill.size()-1;left<right;++left,--right){
            if(skill[left]+skill[right]!=target)return -1;
            chemistry+=1LL*skill[left]*skill[right];
        }
        return chemistry;
    }
};
