class Solution {
    string add(string a,string b){
        string out;
        int i=a.size()-1,j=b.size()-1,carry=0;
        while(i>=0||j>=0||carry){
            int value=carry+(i>=0?a[i--]-'0':0)+(j>=0?b[j--]-'0':0);
            out+=char('0'+value%10);
            carry=value/10;
        }
        reverse(out.begin(),out.end());
        return out;
    }
    public:bool isAdditiveNumber(string num){
        int n=num.size();
        for(int i=1;i<n-1;++i){
            if(num[0]=='0'&&i>1)break;
            for(int j=i+1;j<n;++j){
                if(num[i]=='0'&&j-i>1)break;
                string a=num.substr(0,i),b=num.substr(i,j-i);
                int index=j;
                while(index<n){
                    string sum=add(a,b);
                    if(num.compare(index,sum.size(),sum)!=0)break;
                    index+=sum.size();
                    a=b;
                    b=sum;
                }
                if(index==n)return true;
            }
        }
        return false;
    }
};
