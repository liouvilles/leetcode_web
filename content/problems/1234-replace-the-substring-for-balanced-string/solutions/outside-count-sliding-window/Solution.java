class Solution {
    public int balancedString(String s){
        int[] count=new int[128];
        for(char ch:s.toCharArray())count[ch]++;
        int target=s.length()/4;
        if(valid(count,target))return 0;
        int left=0,best=s.length();
        for(int right=0;right<s.length();right++){
            count[s.charAt(right)]--;
            while(left<=right&&valid(count,target)){
                best=Math.min(best,right-left+1);
                count[s.charAt(left++)]++;
            }
        }
        return best;
    }
    private boolean valid(int[] count,int target){
        return count['Q']<=target&&count['W']<=target&&count['E']<=target&&count['R']<=target;
    }
}
