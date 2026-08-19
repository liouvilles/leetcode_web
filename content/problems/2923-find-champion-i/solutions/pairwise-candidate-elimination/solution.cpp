class Solution { public:int findChampion(vector<vector<int>>& grid){int candidate=0;for(int team=1;team<(int)grid.size();++team)if(grid[candidate][team]==0)candidate=team;return candidate;} };
