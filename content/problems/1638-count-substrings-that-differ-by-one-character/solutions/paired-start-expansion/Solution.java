class Solution {
    public int countSubstrings(String s,String t){
        int answer=0;
        for(int first=0;first<s.length();first++)for(int second=0;second<t.length();second++){
            int mismatch=0;
            for(int offset=0;first+offset<s.length()&&second+offset<t.length();offset++){
                if(s.charAt(first+offset)!=t.charAt(second+offset))mismatch++;
                if(mismatch==1)answer++;
                else if(mismatch>1)break;
            }
        }
        return answer;
    }
}
