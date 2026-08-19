class Solution {
    public: string destCity(vector<vector<string>>& paths){
        unordered_set<string> origins;
        for(auto& path:paths)origins.insert(path[0]);
        for(auto& path:paths)if(!origins.count(path[1]))return path[1];
        return "";
    }
};
