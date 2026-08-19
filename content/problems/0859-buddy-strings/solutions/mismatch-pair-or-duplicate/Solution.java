class Solution {
    public boolean buddyStrings(String s,String goal){
        if(s.length()!=goal.length())return false;
        if(s.equals(goal)){
            Set<Character> seen=new HashSet<>();
            for(char c:s.toCharArray())if(!seen.add(c))return true;
            return false;
        }
        int first=-1,second=-1;
        for(int i=0;i<s.length();i++)if(s.charAt(i)!=goal.charAt(i)){
            if(first<0)first=i;
            else if(second<0)second=i;
            else return false;
        }
        return second>=0&&s.charAt(first)==goal.charAt(second)&&s.charAt(second)==goal.charAt(first);
    }
}
