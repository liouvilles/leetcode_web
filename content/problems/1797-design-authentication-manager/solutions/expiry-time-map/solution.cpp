class AuthenticationManager {
    int ttl;
    unordered_map<string,int> expiry;
    public:AuthenticationManager(int timeToLive):ttl(timeToLive){
    }
    void generate(string tokenId,int currentTime){
        expiry[tokenId]=currentTime+ttl;
    }
    void renew(string tokenId,int currentTime){
        if(expiry[tokenId]>currentTime)expiry[tokenId]=currentTime+ttl;
    }
    int countUnexpiredTokens(int currentTime){
        int count=0;
        for(auto [token,time]:expiry)count+=time>currentTime;
        return count;
    }
};
