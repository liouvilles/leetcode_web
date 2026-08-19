class Solution {
    public int minMaxDifference(int num){
        String digits=String.valueOf(num);
        char source='9';
        for(char character:digits.toCharArray())if(character!='9'){
            source=character;
            break;
        }
        int maximum=Integer.parseInt(digits.replace(source,'9'));
        int minimum=Integer.parseInt(digits.replace(digits.charAt(0),'0'));
        return maximum-minimum;
    }
}
