class Solution {
    public boolean canBeValid(String s,String locked){
        if((s.length()&1)==1)return false;
        int low=0,high=0;
        for(int i=0;i<s.length();i++){
            if(locked.charAt(i)=='0'){
                low--;
                high++;
            }else if(s.charAt(i)=='('){
                low++;
                high++;
            }else{
                low--;
                high--;
            }
            if(high<0)return false;
            low=Math.max(low,0);
        }
        return low==0;
    }
}
