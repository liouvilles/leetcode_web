class SQL {
    unordered_map<string,vector<vector<string>>> tables;
    public:SQL(vector<string>& names,vector<int>& columns){
        for(string& name:names)tables[name]={
        };
    }
    void insertRow(string name,vector<string> row){
        tables[name].push_back(row);
    }
    void deleteRow(string name,int rowId){
        tables[name][rowId-1].clear();
    }
    string selectCell(string name,int rowId,int columnId){
        return tables[name][rowId-1][columnId-1];
    }
};
