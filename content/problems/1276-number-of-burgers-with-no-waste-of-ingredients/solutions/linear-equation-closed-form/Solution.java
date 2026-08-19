class Solution {
    public List<Integer> numOfBurgers(int tomatoSlices,int cheeseSlices){
        int difference=tomatoSlices-2*cheeseSlices;
        if(difference<0||difference%2!=0)return new ArrayList<>();
        int jumbo=difference/2,small=cheeseSlices-jumbo;
        if(small<0)return new ArrayList<>();
        return Arrays.asList(jumbo,small);
    }
}
