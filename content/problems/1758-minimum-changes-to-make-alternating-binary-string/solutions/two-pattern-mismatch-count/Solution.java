class Solution {
    public int minOperations(String text){
        int mismatch=0;
        for(int i=0;i<text.length();i++)if(text.charAt(i)!=(char)('0'+i%2))mismatch++;
        return Math.min(mismatch,text.length()-mismatch);
    }
}
