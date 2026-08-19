class Solution {
    public: vector<string> subdomainVisits(vector<string>& cpdomains){
        map<string,int> counts;
        for(string item:cpdomains){
            int space=item.find(' '),count=stoi(item.substr(0,space));
            string domain=item.substr(space+1);
            while(true){
                counts[domain]+=count;
                int dot=domain.find('.');
                if(dot==string::npos)break;
                domain=domain.substr(dot+1);
            }
        }
        vector<string> answer;
        for(auto& [domain,count]:counts)answer.push_back(to_string(count)+" "+domain);
        return answer;
    }
};
