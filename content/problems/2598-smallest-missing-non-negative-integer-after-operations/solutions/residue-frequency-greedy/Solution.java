class Solution {
    public int findSmallestInteger(int[] nums,int value){
        int[] count=new int[value];
        for(int number:nums)count[(number%value+value)%value]++;
        for(int candidate=0;;candidate++){
            int residue=candidate%value;
            if(count[residue]==0)return candidate;
            count[residue]--;
        }
    }
}
