class Solution {
    public String makeFancyString(String s){
        StringBuilder result=new StringBuilder();
        for(char value:s.toCharArray()){
            int n=result.length();
            if(n>=2&&result.charAt(n-1)==value&&result.charAt(n-2)==value)continue;
            result.append(value);
        }
        return result.toString();
    }
}
