class Solution {
    public int chalkReplacer(int[] chalk,int k){
        long sum=0;
        for(int value:chalk)sum+=value;
        long remaining=k%sum;
        for(int i=0;i<chalk.length;i++){
            if(remaining<chalk[i])return i;
            remaining-=chalk[i];
        }
        return 0;
    }
}
