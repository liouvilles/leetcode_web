class Solution {
    public int garbageCollection(String[] garbage,int[] travel){
        int[] prefix=new int[garbage.length];
        for(int i=1;i<garbage.length;i++)prefix[i]=prefix[i-1]+travel[i-1];
        int[] last=new int[3];
        int answer=0;
        String types="MPG";
        for(int i=0;i<garbage.length;i++){
            answer+=garbage[i].length();
            for(char ch:garbage[i].toCharArray())last[types.indexOf(ch)]=i;
        }
        for(int index:last)answer+=prefix[index];
        return answer;
    }
}
