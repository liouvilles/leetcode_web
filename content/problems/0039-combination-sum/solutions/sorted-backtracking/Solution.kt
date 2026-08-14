class Solution {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        candidates.sort()
        val answer = ArrayList<List<Int>>()
        search(candidates, target, 0, ArrayList(), answer)
        return answer
    }

    private fun search(candidates: IntArray, remaining: Int, start: Int, path: MutableList<Int>, answer: MutableList<List<Int>>) {
        if (remaining == 0) {
            answer.add(ArrayList(path))
            return
        }
        for (index in start until candidates.size) {
            if (candidates[index] > remaining) break
            path.add(candidates[index])
            search(candidates, remaining - candidates[index], index, path, answer)
            path.removeAt(path.lastIndex)
        }
    }
}
