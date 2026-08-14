class Solution { public: int countTriples(int n){int answer=0;for(int a=1;a<=n;++a)for(int b=1;b<=n;++b){int square=a*a+b*b,c=sqrt(square);if(c<=n&&c*c==square)++answer;}return answer;} };
