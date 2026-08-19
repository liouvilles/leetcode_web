class OrderedStream {
    private final String[] values;
    private int pointer=1;
    public OrderedStream(int n){
        values=new String[n+1];
    }
    public List<String> insert(int idKey,String value){
        values[idKey]=value;
        List<String> answer=new ArrayList<>();
        while(pointer<values.length&&values[pointer]!=null)answer.add(values[pointer++]);
        return answer;
    }
}
