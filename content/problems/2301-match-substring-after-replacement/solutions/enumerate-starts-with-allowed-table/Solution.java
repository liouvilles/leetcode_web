class Solution {
    public boolean matchReplacement(String s,String sub,char[][] mappings){
        boolean[][] allowed=new boolean[128][128];
        for(char[] mapping:mappings)allowed[mapping[0]][mapping[1]]=true;
        for(int start=0;start+sub.length()<=s.length();start++){
            boolean matches=true;
            for(int j=0;j<sub.length();j++){
                char from=sub.charAt(j),to=s.charAt(start+j);
                if(from!=to&&!allowed[from][to]){
                    matches=false;
                    break;
                }
            }
            if(matches)return true;
        }
        return false;
    }
}
