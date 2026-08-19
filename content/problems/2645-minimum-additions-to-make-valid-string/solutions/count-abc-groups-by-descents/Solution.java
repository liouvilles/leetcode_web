class Solution {
    public int addMinimum(String word){
        int groups=1;
        for(int i=1;i<word.length();i++)if(word.charAt(i)<=word.charAt(i-1))groups++;
        return groups*3-word.length();
    }
}
