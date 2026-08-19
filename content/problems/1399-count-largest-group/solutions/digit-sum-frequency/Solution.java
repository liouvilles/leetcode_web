class Solution {
    public int countLargestGroup(int n){
        int[] count=new int[100];
        for(int value=1;value<=n;value++){
            int x=value,sum=0;
            while(x>0){
                sum+=x%10;
                x/=10;
            }
            count[sum]++;
        }
        int maximum=0,answer=0;
        for(int size:count)if(size>maximum){
            maximum=size;
            answer=1;
        }else if(size==maximum&&size>0)answer++;
        return answer;
    }
}
