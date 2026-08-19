class Solution {
    public int countAsterisks(String s){
        boolean inside=false;
        int answer=0;
        for(char ch:s.toCharArray())if(ch=='|')inside=!inside;
        else if(ch=='*'&&!inside)answer++;
        return answer;
    }
}
