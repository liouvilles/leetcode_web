class Solution {
    public int minimumBuckets(String street){
        char[] value=street.toCharArray();
        int answer=0;
        for(int i=0;i<value.length;i++)if(value[i]=='H'){
            if(i>0&&value[i-1]=='B')continue;
            if(i+1<value.length&&value[i+1]=='.'){
                value[i+1]='B';
                answer++;
            }else if(i>0&&value[i-1]=='.'){
                value[i-1]='B';
                answer++;
            }else return -1;
        }
        return answer;
    }
}
