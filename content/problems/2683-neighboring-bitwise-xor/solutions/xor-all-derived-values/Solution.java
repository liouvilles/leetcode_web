class Solution {
    public boolean doesValidArrayExist(int[] derived){
        int xor=0;
        for(int value:derived)xor^=value;
        return xor==0;
    }
}
