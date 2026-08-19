class Solution { public:string makeSmallestPalindrome(string s){for(int left=0,right=s.size()-1;left<right;++left,--right)s[left]=s[right]=min(s[left],s[right]);return s;} };
