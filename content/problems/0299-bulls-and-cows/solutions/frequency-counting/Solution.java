class Solution {
    public String getHint(String secret,String guess){
        int bulls=0;
        int[] first=new int[10],second=new int[10];
        for(int i=0;i<secret.length();i++){
            if(secret.charAt(i)==guess.charAt(i))bulls++;
            else{
                first[secret.charAt(i)-'0']++;
                second[guess.charAt(i)-'0']++;
            }
        }
        int cows=0;
        for(int d=0;d<10;d++)cows+=Math.min(first[d],second[d]);
        return bulls+"A"+cows+"B";
    }
}
