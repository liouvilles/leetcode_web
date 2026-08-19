class Solution {
    public boolean isPathCrossing(String path){
        int x=0,y=0;
        Set<String> seen=new HashSet<>();
        seen.add("0,0");
        for(char direction:path.toCharArray()){
            if(direction=='N')y++;
            else if(direction=='S')y--;
            else if(direction=='E')x++;
            else x--;
            if(!seen.add(x+","+y))return true;
        }
        return false;
    }
}
