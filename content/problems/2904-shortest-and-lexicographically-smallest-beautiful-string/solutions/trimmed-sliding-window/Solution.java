class Solution {
    public String shortestBeautifulSubstring(String s,int k){
        int left=0,ones=0;
        String answer="";
        for(int right=0;right<s.length();right++){
            if(s.charAt(right)=='1')ones++;
            while(left<=right&&(s.charAt(left)=='0'||ones>k)){
                if(s.charAt(left++)=='1')ones--;
            }
            if(ones==k){
                String candidate=s.substring(left,right+1);
                if(answer.isEmpty()||candidate.length()<answer.length()||candidate.length()==answer.length()&&candidate.compareTo(answer)<0)answer=candidate;
            }
        }
        return answer;
    }
}
