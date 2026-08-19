class Solution { public:bool isReachableAtTime(int sx,int sy,int fx,int fy,int t){int distance=max(abs(sx-fx),abs(sy-fy));return distance<=t&&!(distance==0&&t==1);} };
