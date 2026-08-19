class Solution {
    public boolean reorderedPowerOf2(int n){
        String target=signature(n);
        for(int power=1;power>0&&power<=1000000000;power<<=1)if(signature(power).equals(target))return true;
        return false;
    }
    private String signature(int value){
        char[] chars=Integer.toString(value).toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
