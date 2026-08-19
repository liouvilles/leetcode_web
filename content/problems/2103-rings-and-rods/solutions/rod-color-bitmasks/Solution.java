class Solution {
    public int countPoints(String rings){
        int[] mask=new int[10];
        for(int i=0;i<rings.length();i+=2){
            int bit=rings.charAt(i)=='R'?1:rings.charAt(i)=='G'?2:4;
            mask[rings.charAt(i+1)-'0']|=bit;
        }
        int answer=0;
        for(int value:mask)if(value==7)answer++;
        return answer;
    }
}
