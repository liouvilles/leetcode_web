class Solution {
    public String removeDuplicates(String s,int k){
        StringBuilder stack=new StringBuilder();
        int[] counts=new int[s.length()];
        for(char ch:s.toCharArray()){
            int index=stack.length();
            counts[index]=index>0&&stack.charAt(index-1)==ch?counts[index-1]+1:1;
            stack.append(ch);
            if(counts[index]==k)stack.delete(stack.length()-k,stack.length());
        }
        return stack.toString();
    }
}
