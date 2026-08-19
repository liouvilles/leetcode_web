class Solution {
    public String getSmallestString(String s,int k){
        char[] letters=s.toCharArray();
        for(int index=0;index<letters.length&&k>0;index++){
            int direct=letters[index]-'a',distance=Math.min(direct,26-direct);
            if(distance<=k){
                letters[index]='a';
                k-=distance;
            }else{
                letters[index]=(char)(letters[index]-k);
                k=0;
            }
        }
        return new String(letters);
    }
}
