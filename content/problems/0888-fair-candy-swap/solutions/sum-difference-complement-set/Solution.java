class Solution {
    public int[] fairCandySwap(int[] aliceSizes,int[] bobSizes){
        int difference=(Arrays.stream(aliceSizes).sum()-Arrays.stream(bobSizes).sum())/2;
        Set<Integer> bob=new HashSet<>();
        for(int value:bobSizes)bob.add(value);
        for(int alice:aliceSizes)if(bob.contains(alice-difference))return new int[]{
            alice,alice-difference
        };
        return new int[0];
    }
}
