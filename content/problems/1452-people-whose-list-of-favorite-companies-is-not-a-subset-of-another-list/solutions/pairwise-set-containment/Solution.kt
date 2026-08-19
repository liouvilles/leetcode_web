class Solution {
    fun peopleIndexes(favoriteCompanies:List<List<String>>):List<Int>{
        val sets=favoriteCompanies.map{
            it.toSet()
        };
        return sets.indices.filter{
            i->sets.indices.none{
                j->i!=j&&sets[j].size>=sets[i].size&&sets[j].containsAll(sets[i])
            }
        }
    }
}
