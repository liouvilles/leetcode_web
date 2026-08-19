class Solution {
    public int[] frequencySort(int[] nums){
        Map<Integer,Integer> frequency=new HashMap<>();
        for(int value:nums)frequency.put(value,frequency.getOrDefault(value,0)+1);
        Integer[] values=Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(values,(a,b)->!frequency.get(a).equals(frequency.get(b))?frequency.get(a)-frequency.get(b):b-a);
        for(int i=0;i<nums.length;i++)nums[i]=values[i];
        return nums;
    }
}
