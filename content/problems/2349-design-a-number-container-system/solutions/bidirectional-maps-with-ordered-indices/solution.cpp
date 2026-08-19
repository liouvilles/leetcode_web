class NumberContainers {
    unordered_map<int,int> indexToNumber;
    unordered_map<int,set<int>> numberToIndices;
    public:NumberContainers(){
    }
    void change(int index,int number){
        if(indexToNumber.count(index))numberToIndices[indexToNumber[index]].erase(index);
        indexToNumber[index]=number;
        numberToIndices[number].insert(index);
    }
    int find(int number){
        return numberToIndices[number].empty()?-1:*numberToIndices[number].begin();
    }
};
