class Solution {
    private static class Fenwick{
        int[] tree;
        Fenwick(int n){tree=new int[n+1];}
        void add(int index){for(;index<tree.length;index+=index&-index)tree[index]++;}
        int query(int index){int result=0;for(;index>0;index-=index&-index)result+=tree[index];return result;}
    }
    public int[] resultArray(int[] nums){
        int[] sorted=nums.clone();
        Arrays.sort(sorted);
        List<Integer> first=new ArrayList<>(),second=new ArrayList<>();
        Fenwick firstTree=new Fenwick(nums.length),secondTree=new Fenwick(nums.length);
        first.add(nums[0]);second.add(nums[1]);
        firstTree.add(Arrays.binarySearch(sorted,nums[0])+1);
        secondTree.add(Arrays.binarySearch(sorted,nums[1])+1);
        for(int index=2;index<nums.length;index++){
            int rank=Arrays.binarySearch(sorted,nums[index])+1;
            int firstGreater=first.size()-firstTree.query(rank);
            int secondGreater=second.size()-secondTree.query(rank);
            if(firstGreater>secondGreater||firstGreater==secondGreater&&first.size()<=second.size()){
                first.add(nums[index]);firstTree.add(rank);
            }else{
                second.add(nums[index]);secondTree.add(rank);
            }
        }
        int[] answer=new int[nums.length];
        int write=0;
        for(int value:first)answer[write++]=value;
        for(int value:second)answer[write++]=value;
        return answer;
    }
}
