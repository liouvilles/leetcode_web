class MKAverage {
    int m,k;
    deque<int> window;
    public:MKAverage(int m,int k):m(m),k(k){
    }
    void addElement(int num){
        window.push_back(num);
        if((int)window.size()>m)window.pop_front();
    }
    int calculateMKAverage(){
        if((int)window.size()<m)return -1;
        vector<int> values(window.begin(),window.end());
        sort(values.begin(),values.end());
        long long sum=accumulate(values.begin()+k,values.end()-k,0LL);
        return sum/(m-2*k);
    }
};
