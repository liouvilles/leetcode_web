class Solution {
    private List<Integer> group(int[] values,int parity){
        List<Integer> result=new ArrayList<>();
        for(int value:values)if(value%2==parity)result.add(value);
        Collections.sort(result);
        return result;
    }
    public long makeSimilar(int[] nums,int[] target){
        long difference=0;
        for(int parity=0;parity<2;parity++){
            List<Integer> a=group(nums,parity),b=group(target,parity);
            for(int i=0;i<a.size();i++)difference+=Math.abs((long)a.get(i)-b.get(i));
        }
        return difference/4;
    }
}
