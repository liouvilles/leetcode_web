class Solution {
    public:double calculateTax(vector<vector<int>>& brackets,int income){
        double tax=0;
        int previous=0;
        for(auto& bracket:brackets){
            int taxable=max(0,min(income,bracket[0])-previous);
            tax+=taxable*bracket[1]/100.0;
            if(income<=bracket[0])break;
            previous=bracket[0];
        }
        return tax;
    }
};
