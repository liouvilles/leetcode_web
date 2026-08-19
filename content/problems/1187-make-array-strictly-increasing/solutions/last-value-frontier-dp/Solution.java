class Solution {
    public int makeArrayIncreasing(int[] arr1,int[] arr2){
        Arrays.sort(arr2);
        Map<Integer,Integer> states=new HashMap<>();
        states.put(-1,0);
        for(int value:arr1){
            TreeMap<Integer,Integer> next=new TreeMap<>();
            for(Map.Entry<Integer,Integer> state:states.entrySet()){
                int last=state.getKey(),operations=state.getValue();
                if(value>last)next.merge(value,operations,Math::min);
                int index=upperBound(arr2,last);
                if(index<arr2.length)next.merge(arr2[index],operations+1,Math::min);
            }
            Map<Integer,Integer> pruned=new HashMap<>();
            int best=Integer.MAX_VALUE;
            for(Map.Entry<Integer,Integer> state:next.entrySet())if(state.getValue()<best){
                best=state.getValue();
                pruned.put(state.getKey(),best);
            }
            states=pruned;
            if(states.isEmpty())return -1;
        }
        return Collections.min(states.values());
    }
    private int upperBound(int[] values,int target){
        int left=0,right=values.length;
        while(left<right){
            int middle=(left+right)/2;
            if(values[middle]<=target)left=middle+1;
            else right=middle;
        }
        return left;
    }
}
