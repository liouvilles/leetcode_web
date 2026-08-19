class Solution {
    private void putMin(Map<Integer,Integer> map,int key,int value){
        Integer previous=map.get(key);
        if(previous==null||value<previous)map.put(key,value);
    }
    public int minimumValueSum(int[] nums,int[] andValues){
        int parts=andValues.length;
        List<Map<Integer,Integer>> active=new ArrayList<>();
        for(int part=0;part<parts;part++)active.add(new HashMap<>());
        active.get(0).put(-1,0);
        int answer=Integer.MAX_VALUE;
        for(int index=0;index<nums.length;index++){
            List<Map<Integer,Integer>> next=new ArrayList<>();
            for(int part=0;part<parts;part++)next.add(new HashMap<>());
            for(int part=0;part<parts;part++)for(Map.Entry<Integer,Integer> entry:active.get(part).entrySet()){
                int merged=entry.getKey()&nums[index],target=andValues[part],cost=entry.getValue();
                if((merged&target)!=target)continue;
                putMin(next.get(part),merged,cost);
                if(merged==target){
                    int closed=cost+nums[index];
                    if(part==parts-1){
                        if(index==nums.length-1)answer=Math.min(answer,closed);
                    }else putMin(next.get(part+1),-1,closed);
                }
            }
            active=next;
        }
        return answer==Integer.MAX_VALUE?-1:answer;
    }
}
