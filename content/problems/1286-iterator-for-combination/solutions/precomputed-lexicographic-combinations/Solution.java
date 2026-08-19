class CombinationIterator {
    private final List<String> combinations=new ArrayList<>();
    private int index=0;
    private final String characters;
    private final int length;
    public CombinationIterator(String characters,int combinationLength){
        this.characters=characters;
        this.length=combinationLength;
        generate(0,new StringBuilder());
    }
    private void generate(int start,StringBuilder current){
        if(current.length()==length){
            combinations.add(current.toString());
            return;
        }
        for(int i=start;i<=characters.length()-(length-current.length());i++){
            current.append(characters.charAt(i));
            generate(i+1,current);
            current.deleteCharAt(current.length()-1);
        }
    }
    public String next(){
        return combinations.get(index++);
    }
    public boolean hasNext(){
        return index<combinations.size();
    }
}
