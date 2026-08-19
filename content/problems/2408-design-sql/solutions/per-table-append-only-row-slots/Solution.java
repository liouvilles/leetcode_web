class SQL {
    Map<String,List<String[]>> tables=new HashMap<>();
    public SQL(String[] names,int[] columns){
        for(String name:names)tables.put(name,new ArrayList<>());
    }
    public void insertRow(String name,String[] row){
        tables.get(name).add(row.clone());
    }
    public void deleteRow(String name,int rowId){
        tables.get(name).set(rowId-1,null);
    }
    public String selectCell(String name,int rowId,int columnId){
        return tables.get(name).get(rowId-1)[columnId-1];
    }
}
