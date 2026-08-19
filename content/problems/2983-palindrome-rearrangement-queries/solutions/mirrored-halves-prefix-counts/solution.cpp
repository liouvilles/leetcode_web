class Solution {
    int range(const vector<array<int,26>>& prefix,int left,int right,int letter){
        return left>right?0:prefix[right+1][letter]-prefix[left][letter];
    }
    int mismatchRange(const vector<int>& prefix,int left,int right){
        return left>right?0:prefix[right+1]-prefix[left];
    }
    public:vector<bool> canMakePalindromeQueries(string s,vector<vector<int>>& queries){
        int n=s.size(),half=n/2;
        string first=s.substr(0,half),second=s.substr(half);
        reverse(second.begin(),second.end());
        vector<array<int,26>> firstCount(half+1),secondCount(half+1);
        firstCount[0].fill(0);
        secondCount[0].fill(0);
        vector<int> mismatch(half+1);
        for(int index=0;index<half;++index){
            firstCount[index+1]=firstCount[index];
            secondCount[index+1]=secondCount[index];
            ++firstCount[index+1][first[index]-'a'];
            ++secondCount[index+1][second[index]-'a'];
            mismatch[index+1]=mismatch[index]+(first[index]!=second[index]);
        }
        vector<bool> answer;
        answer.reserve(queries.size());
        for(auto& query:queries){
            int firstLeft=query[0],firstRight=query[1],secondLeft=n-1-query[3],secondRight=n-1-query[2];
            int overlapLeft=max(firstLeft,secondLeft),overlapRight=min(firstRight,secondRight);
            bool valid=mismatch[half]-mismatchRange(mismatch,firstLeft,firstRight)-mismatchRange(mismatch,secondLeft,secondRight)+mismatchRange(mismatch,overlapLeft,overlapRight)==0;
            for(int letter=0;letter<26&&valid;++letter){
                int availableFirst=range(firstCount,firstLeft,firstRight,letter);
                int requiredFirst=range(secondCount,firstLeft,firstRight,letter)-range(secondCount,overlapLeft,overlapRight,letter);
                int availableSecond=range(secondCount,secondLeft,secondRight,letter);
                int requiredSecond=range(firstCount,secondLeft,secondRight,letter)-range(firstCount,overlapLeft,overlapRight,letter);
                int remainingFirst=availableFirst-requiredFirst,remainingSecond=availableSecond-requiredSecond;
                if(remainingFirst<0||remainingSecond<0||remainingFirst!=remainingSecond)valid=false;
            }
            answer.push_back(valid);
        }
        return answer;
    }
};
