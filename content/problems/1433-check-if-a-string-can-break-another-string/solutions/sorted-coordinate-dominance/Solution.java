class Solution {
    public boolean checkIfCanBreak(String s1,String s2){
        char[] first=s1.toCharArray(),second=s2.toCharArray();
        Arrays.sort(first);
        Arrays.sort(second);
        boolean firstBreaks=true,secondBreaks=true;
        for(int i=0;i<first.length;i++){
            if(first[i]<second[i])firstBreaks=false;
            if(first[i]>second[i])secondBreaks=false;
        }
        return firstBreaks||secondBreaks;
    }
}
