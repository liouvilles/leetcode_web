class Solution {
    int[] tasks,workers;
    int pills,strength;
    private void remove(TreeMap<Integer,Integer> map,int value){
        int count=map.get(value);
        if(count==1)map.remove(value);
        else map.put(value,count-1);
    }
    private boolean can(int count){
        TreeMap<Integer,Integer> available=new TreeMap<>();
        for(int i=workers.length-count;i<workers.length;i++)available.merge(workers[i],1,Integer::sum);
        int remainingPills=pills;
        for(int task=count-1;task>=0;task--){
            Integer worker=available.ceilingKey(tasks[task]);
            if(worker!=null)remove(available,worker);
            else{
                if(remainingPills==0)return false;
                worker=available.ceilingKey(tasks[task]-strength);
                if(worker==null)return false;
                remainingPills--;
                remove(available,worker);
            }
        }
        return true;
    }
    public int maxTaskAssign(int[] tasks,int[] workers,int pills,int strength){
        Arrays.sort(tasks);
        Arrays.sort(workers);
        this.tasks=tasks;
        this.workers=workers;
        this.pills=pills;
        this.strength=strength;
        int left=0,right=Math.min(tasks.length,workers.length);
        while(left<right){
            int middle=(left+right+1)/2;
            if(can(middle))left=middle;
            else right=middle-1;
        }
        return left;
    }
}
