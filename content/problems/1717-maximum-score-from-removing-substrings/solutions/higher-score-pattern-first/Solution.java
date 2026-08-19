class Solution {
    private static class Removal{
        String text;
        int count;
        Removal(String text,int count){
            this.text=text;
            this.count=count;
        }
    }
    private Removal remove(String text,char first,char second){
        StringBuilder stack=new StringBuilder();
        int count=0;
        for(char letter:text.toCharArray())if(letter==second&&stack.length()>0&&stack.charAt(stack.length()-1)==first){
            stack.deleteCharAt(stack.length()-1);
            count++;
        }else stack.append(letter);
        return new Removal(stack.toString(),count);
    }
    public int maximumGain(String text,int x,int y){
        if(x>=y){
            Removal high=remove(text,'a','b'),low=remove(high.text,'b','a');
            return high.count*x+low.count*y;
        }
        Removal high=remove(text,'b','a'),low=remove(high.text,'a','b');
        return high.count*y+low.count*x;
    }
}
