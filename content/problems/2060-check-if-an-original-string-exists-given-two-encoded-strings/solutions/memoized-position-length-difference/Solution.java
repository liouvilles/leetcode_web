class Solution {
    String first,second;
    Set<String> failed=new HashSet<>();
    private boolean digit(char value){
        return value>='0'&&value<='9';
    }
    private boolean dfs(int i,int j,int difference){
        if(i==first.length()&&j==second.length())return difference==0;
        String key=i+","+j+","+difference;
        if(failed.contains(key))return false;
        if(i<first.length()&&digit(first.charAt(i))){
            int value=0;
            for(int end=i;end<first.length()&&end<i+3&&digit(first.charAt(end));end++){
                value=value*10+first.charAt(end)-'0';
                if(dfs(end+1,j,difference+value))return true;
            }
        }else if(j<second.length()&&digit(second.charAt(j))){
            int value=0;
            for(int end=j;end<second.length()&&end<j+3&&digit(second.charAt(end));end++){
                value=value*10+second.charAt(end)-'0';
                if(dfs(i,end+1,difference-value))return true;
            }
        }else if(difference<0&&i<first.length()&&dfs(i+1,j,difference+1))return true;
        else if(difference>0&&j<second.length()&&dfs(i,j+1,difference-1))return true;
        else if(difference==0&&i<first.length()&&j<second.length()&&first.charAt(i)==second.charAt(j)&&dfs(i+1,j+1,0))return true;
        failed.add(key);
        return false;
    }
    public boolean possiblyEquals(String s1,String s2){
        first=s1;
        second=s2;
        return dfs(0,0,0);
    }
}
