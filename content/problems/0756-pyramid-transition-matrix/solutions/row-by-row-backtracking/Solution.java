class Solution {
    private final Map<String,List<Character>> choices=new HashMap<>();
    public boolean pyramidTransition(String bottom,List<String> allowed){
        for(String rule:allowed)choices.computeIfAbsent(rule.substring(0,2),key->new ArrayList<>()).add(rule.charAt(2));
        return solve(bottom);
    }
    private boolean solve(String row){
        if(row.length()==1)return true;
        return build(row,0,new StringBuilder());
    }
    private boolean build(String row,int position,StringBuilder next){
        if(position==row.length()-1)return solve(next.toString());
        List<Character> options=choices.get(row.substring(position,position+2));
        if(options==null)return false;
        for(char c:options){
            next.append(c);
            if(build(row,position+1,next))return true;
            next.setLength(next.length()-1);
        }
        return false;
    }
}
