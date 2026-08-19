class Solution {
    public int countBinarySubstrings(String s){
        int previous=0,current=1,answer=0;
        for(int i=1;i<s.length();i++)if(s.charAt(i)==s.charAt(i-1))current++;
        else{
            answer+=Math.min(previous,current);
            previous=current;
            current=1;
        }
        return answer+Math.min(previous,current);
    }
}
