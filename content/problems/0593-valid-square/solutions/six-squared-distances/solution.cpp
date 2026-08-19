class Solution {
    long long distance(vector<int>& a,vector<int>& b){
        long long x=1LL*a[0]-b[0],y=1LL*a[1]-b[1];
        return x*x+y*y;
    }
    public:bool validSquare(vector<int>& p1,vector<int>& p2,vector<int>& p3,vector<int>& p4){
        vector<vector<int>*> points={
            &p1,&p2,&p3,&p4
        };
        vector<long long> distances;
        for(int i=0;i<4;++i)for(int j=i+1;j<4;++j)distances.push_back(distance(*points[i],*points[j]));
        sort(distances.begin(),distances.end());
        return distances[0]>0&&distances[0]==distances[3]&&distances[4]==distances[5]&&distances[4]==2*distances[0];
    }
};
