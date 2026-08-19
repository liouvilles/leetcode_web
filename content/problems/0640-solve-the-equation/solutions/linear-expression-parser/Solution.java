class Solution {
    public String solveEquation(String equation){
        String[] sides=equation.split("=");
        int[] left=parse(sides[0]),right=parse(sides[1]);
        int coefficient=left[0]-right[0],constant=right[1]-left[1];
        if(coefficient==0)return constant==0?"Infinite solutions":"No solution";
        return "x="+constant/coefficient;
    }
    private int[] parse(String expression){
        int coefficient=0,constant=0,index=0,sign=1;
        while(index<expression.length()){
            if(expression.charAt(index)=='+'||expression.charAt(index)=='-')sign=expression.charAt(index++)=='-'?-1:1;
            int start=index,value=0;
            while(index<expression.length()&&Character.isDigit(expression.charAt(index)))value=value*10+expression.charAt(index++)-'0';
            if(index<expression.length()&&expression.charAt(index)=='x'){
                coefficient+=sign*(index==start?1:value);
                index++;
            }else constant+=sign*value;
        }
        return new int[]{
            coefficient,constant
        };
    }
}
