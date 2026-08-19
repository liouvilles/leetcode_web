class Solution {
    public String countOfAtoms(String formula){
        Deque<Map<String,Integer>> stack=new ArrayDeque<>();
        stack.addLast(new HashMap<>());
        int index=0;
        while(index<formula.length()){
            char c=formula.charAt(index);
            if(c=='('){
                stack.addLast(new HashMap<>());
                index++;
            }else if(c==')'){
                index++;
                int start=index;
                while(index<formula.length()&&Character.isDigit(formula.charAt(index)))index++;
                int multiplier=start==index?1:Integer.parseInt(formula.substring(start,index));
                Map<String,Integer> group=stack.removeLast(),parent=stack.peekLast();
                for(Map.Entry<String,Integer> entry:group.entrySet())parent.put(entry.getKey(),parent.getOrDefault(entry.getKey(),0)+entry.getValue()*multiplier);
            }else{
                int start=index++;
                while(index<formula.length()&&Character.isLowerCase(formula.charAt(index)))index++;
                String atom=formula.substring(start,index);
                start=index;
                while(index<formula.length()&&Character.isDigit(formula.charAt(index)))index++;
                int count=start==index?1:Integer.parseInt(formula.substring(start,index));
                Map<String,Integer> current=stack.peekLast();
                current.put(atom,current.getOrDefault(atom,0)+count);
            }
        }
        StringBuilder answer=new StringBuilder();
        for(Map.Entry<String,Integer> entry:new TreeMap<>(stack.peekLast()).entrySet()){
            answer.append(entry.getKey());
            if(entry.getValue()>1)answer.append(entry.getValue());
        }
        return answer.toString();
    }
}
