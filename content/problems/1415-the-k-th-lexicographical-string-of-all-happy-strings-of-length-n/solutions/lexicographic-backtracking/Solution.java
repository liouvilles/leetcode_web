class Solution {
    private int count,k,n;
    private String answer="";
    private boolean generate(StringBuilder current){
        if(current.length()==n){
            if(++count==k){
                answer=current.toString();
                return true;
            }
            return false;
        }
        for(char value='a';value<='c';value++){
            if(current.length()>0&&current.charAt(current.length()-1)==value)continue;
            current.append(value);
            if(generate(current))return true;
            current.deleteCharAt(current.length()-1);
        }
        return false;
    }
    public String getHappyString(int n,int k){
        this.n=n;
        this.k=k;
        generate(new StringBuilder());
        return answer;
    }
}
