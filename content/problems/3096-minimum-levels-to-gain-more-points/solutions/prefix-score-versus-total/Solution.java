class Solution {
    public int minimumLevels(int[] possible){
        int total=0;
        for(int value:possible)total+=value==1?1:-1;
        int prefix=0;
        for(int index=0;index+1<possible.length;index++){
            prefix+=possible[index]==1?1:-1;
            if(prefix>total-prefix)return index+1;
        }
        return -1;
    }
}
