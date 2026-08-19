class ProductOfNumbers {
    vector<int> prefix{
        1
    };
    public:void add(int num){
        if(!num)prefix={
            1
        };
        else prefix.push_back(prefix.back()*num);
    }
    int getProduct(int k){
        return k>=(int)prefix.size()?0:prefix.back()/prefix[prefix.size()-1-k];
    }
};
