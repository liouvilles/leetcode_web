class Solution {
    public:bool asteroidsDestroyed(int mass,vector<int>& asteroids){
        sort(asteroids.begin(),asteroids.end());
        long long current=mass;
        for(int asteroid:asteroids){
            if(current<asteroid)return false;
            current+=asteroid;
        }
        return true;
    }
};
