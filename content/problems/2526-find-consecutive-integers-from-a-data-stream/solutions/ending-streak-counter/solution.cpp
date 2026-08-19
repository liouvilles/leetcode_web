class DataStream { int value,k,streak=0;public:DataStream(int value,int k):value(value),k(k){}bool consec(int num){streak=num==value?streak+1:0;return streak>=k;} };
