class Solution {
    int gcd(int a,int b){
        while(b){
            int temporary=a%b;
            a=b;
            b=temporary;
        }
        return a;
    }
    public:vector<int> replaceNonCoprimes(vector<int>& nums){
        vector<int> stack;
        for(int value:nums){
            while(!stack.empty()){
                int top=stack.back(),divisor=gcd(top,value);
                if(divisor==1)break;
                stack.pop_back();
                value=(long long)top/divisor*value;
            }
            stack.push_back(value);
        }
        return stack;
    }
};
