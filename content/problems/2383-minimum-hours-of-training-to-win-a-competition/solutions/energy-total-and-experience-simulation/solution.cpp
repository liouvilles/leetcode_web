class Solution {
    public:int minNumberOfHours(int initialEnergy,int initialExperience,vector<int>& energy,vector<int>& experience){
        int training=max(0,accumulate(energy.begin(),energy.end(),0)+1-initialEnergy),current=initialExperience;
        for(int opponent:experience){
            if(current<=opponent){
                training+=opponent+1-current;
                current=opponent+1;
            }
            current+=opponent;
        }
        return training;
    }
};
