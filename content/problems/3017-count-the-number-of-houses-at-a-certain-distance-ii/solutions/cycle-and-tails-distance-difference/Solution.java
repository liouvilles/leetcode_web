class Solution {
    private void add(long[] difference,int left,int right,long value){
        if(left>right)return;
        difference[left]+=value;
        difference[right+1]-=value;
    }
    private void addTailToCycle(long[] difference,int tail,int cycle){
        if(tail==0)return;
        add(difference,1,tail,1);
        for(int distance=1;2*distance<cycle;distance++)add(difference,distance+1,distance+tail,2);
        if(cycle%2==0)add(difference,cycle/2+1,cycle/2+tail,1);
    }
    public long[] countOfPairs(int n,int x,int y){
        if(x>y){
            int value=x;
            x=y;
            y=value;
        }
        long[] answer=new long[n];
        if(y-x<=1){
            for(int distance=1;distance<n;distance++)answer[distance-1]=2L*(n-distance);
            return answer;
        }
        int leftTail=x-1,rightTail=n-y,cycle=y-x+1;
        long[] difference=new long[n+2];
        for(int distance=1;distance<leftTail;distance++)add(difference,distance,distance,leftTail-distance);
        for(int distance=1;distance<rightTail;distance++)add(difference,distance,distance,rightTail-distance);
        for(int distance=1;2*distance<cycle;distance++)add(difference,distance,distance,cycle);
        if(cycle%2==0)add(difference,cycle/2,cycle/2,cycle/2);
        addTailToCycle(difference,leftTail,cycle);
        addTailToCycle(difference,rightTail,cycle);
        if(rightTail>0)for(int depth=1;depth<=leftTail;depth++)add(difference,depth+2,depth+rightTail+1,1);
        long current=0;
        for(int distance=1;distance<=n;distance++){
            current+=difference[distance];
            answer[distance-1]=2*current;
        }
        return answer;
    }
}
