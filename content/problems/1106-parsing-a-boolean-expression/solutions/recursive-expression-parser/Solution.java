class Solution {
    private String expression;
    private int index;
    public boolean parseBoolExpr(String expression){
        this.expression=expression;
        index=0;
        return parse();
    }
    private boolean parse(){
        char ch=expression.charAt(index++);
        if(ch=='t')return true;
        if(ch=='f')return false;
        index++;
        if(ch=='!'){
            boolean value=!parse();
            index++;
            return value;
        }
        boolean value=ch=='&';
        while(true){
            boolean next=parse();
            value=ch=='&'?value&&next:value||next;
            if(expression.charAt(index)==')'){
                index++;
                return value;
            }
            index++;
        }
    }
}
