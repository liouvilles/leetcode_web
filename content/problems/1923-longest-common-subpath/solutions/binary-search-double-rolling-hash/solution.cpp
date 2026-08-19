class Solution {
    static const long long M1=1000000007,M2=1000000009,BASE=911382;
    vector<long long> power1,power2;
    unsigned long long key(long long a,long long b){
        return ((unsigned long long)a<<32)^b;
    }
    unordered_set<unsigned long long> hashes(vector<int>& path,int length){
        vector<long long> first(path.size()+1),second(path.size()+1);
        for(int i=0;i<(int)path.size();++i){
            first[i+1]=(first[i]*BASE+path[i]+1)%M1;
            second[i+1]=(second[i]*BASE+path[i]+1)%M2;
        }
        unordered_set<unsigned long long> result;
        for(int left=0;left+length<=(int)path.size();++left){
            long long a=(first[left+length]-first[left]*power1[length]%M1+M1)%M1,b=(second[left+length]-second[left]*power2[length]%M2+M2)%M2;
            result.insert(key(a,b));
        }
        return result;
    }
    bool check(vector<vector<int>>& paths,int length){
        unordered_set<unsigned long long> common;
        bool firstPath=true;
        for(auto& path:paths){
            auto current=hashes(path,length);
            if(firstPath){
                common.swap(current);
                firstPath=false;
            }else for(auto it=common.begin();it!=common.end();)if(!current.count(*it))it=common.erase(it);
            else ++it;
            if(common.empty())return false;
        }
        return true;
    }
    public: int longestCommonSubpath(int n,vector<vector<int>>& paths){
        int maximum=0,right=INT_MAX;
        for(auto& path:paths){
            maximum=max(maximum,(int)path.size());
            right=min(right,(int)path.size());
        }
        power1.resize(maximum+1);
        power2.resize(maximum+1);
        power1[0]=power2[0]=1;
        for(int i=1;i<=maximum;++i){
            power1[i]=power1[i-1]*BASE%M1;
            power2[i]=power2[i-1]*BASE%M2;
        }
        int left=0;
        while(left<right){
            int middle=left+(right-left+1)/2;
            if(check(paths,middle))left=middle;
            else right=middle-1;
        }
        return left;
    }
};
