class Solution {
    bool vowel(char c){
        return string("aeiouAEIOU").find(c)!=string::npos;
    }
    public:string reverseVowels(string s){
        int left=0,right=s.size()-1;
        while(left<right){
            while(left<right&&!vowel(s[left]))++left;
            while(left<right&&!vowel(s[right]))--right;
            swap(s[left++],s[right--]);
        }
        return s;
    }
};
