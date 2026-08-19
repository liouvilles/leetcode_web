class Solution {
    public String subStrHash(String s,int power,int modulo,int k,int hashValue){
        long powerK=1;
        for(int i=0;i<k;i++)powerK=powerK*power%modulo;
        long hash=0;
        int answer=0;
        for(int i=s.length()-1;i>=0;i--){
            hash=(hash*power+s.charAt(i)-'a'+1)%modulo;
            if(i+k<s.length())hash=(hash-(s.charAt(i+k)-'a'+1)*powerK%modulo+modulo)%modulo;
            if(i<=s.length()-k&&hash==hashValue)answer=i;
        }
        return s.substring(answer,answer+k);
    }
}
