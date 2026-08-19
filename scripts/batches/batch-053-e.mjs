const solution = (id, title, idea, steps, time, space, java, kotlin, cpp) => ({
  id,
  title,
  kind: '最优',
  idea,
  steps,
  complexity: { time, space },
  code: { java, kotlin, cpp },
})

export default {
  batchId: 'batch-053',
  problems: [
    {
      id: 3072,
      slug: 'distribute-elements-into-two-arrays-ii',
      title: '将元素分配到两个数组中 II',
      studyTags: ['数组', '树状数组', '离散化', '模拟'],
      summary: '以 nums 前两个元素初始化两个数组；之后优先把当前值放入含有更多严格大于它的元素的数组，次数相同则放入更短的数组，仍相同则放入第一个数组，最后连接两数组。',
      insight: '分配决策需要动态查询每个数组中严格大于当前值的元素数。先对 nums 离散化，再为两个数组各维护一棵树状数组；已加入数减去不大于当前值的前缀频次即可得到 greaterCount。',
      pitfalls: ['greaterCount 只统计严格大于当前值的元素', 'greaterCount 相同时先比较数组长度', '长度也相同时选择 arr1', '最终返回 arr1 后接 arr2', 'nums 可重复且值可达十亿，需要离散化'],
      solutions: [
        solution(
          'coordinate-compression-and-two-fenwick-trees',
          '离散化与两棵树状数组',
          '用树状数组在线维护两个结果数组的值频率与严格较大元素数。',
          ['复制并排序 nums 作为离散化坐标', '分别建立 first、second 与对应树状数组', '把前两个元素加入各自数组和树状数组', '查询两个数组中严格大于当前值的数量', '按 greaterCount、长度、arr1 优先级决定目标数组', '同步追加元素并更新对应树状数组', '连接并返回两个数组'],
          'O(n log n)',
          'O(n)',
          `class Solution {
    private static class Fenwick{
        int[] tree;
        Fenwick(int n){tree=new int[n+1];}
        void add(int index){for(;index<tree.length;index+=index&-index)tree[index]++;}
        int query(int index){int result=0;for(;index>0;index-=index&-index)result+=tree[index];return result;}
    }
    public int[] resultArray(int[] nums){
        int[] sorted=nums.clone();
        Arrays.sort(sorted);
        List<Integer> first=new ArrayList<>(),second=new ArrayList<>();
        Fenwick firstTree=new Fenwick(nums.length),secondTree=new Fenwick(nums.length);
        first.add(nums[0]);second.add(nums[1]);
        firstTree.add(Arrays.binarySearch(sorted,nums[0])+1);
        secondTree.add(Arrays.binarySearch(sorted,nums[1])+1);
        for(int index=2;index<nums.length;index++){
            int rank=Arrays.binarySearch(sorted,nums[index])+1;
            int firstGreater=first.size()-firstTree.query(rank);
            int secondGreater=second.size()-secondTree.query(rank);
            if(firstGreater>secondGreater||firstGreater==secondGreater&&first.size()<=second.size()){
                first.add(nums[index]);firstTree.add(rank);
            }else{
                second.add(nums[index]);secondTree.add(rank);
            }
        }
        int[] answer=new int[nums.length];
        int write=0;
        for(int value:first)answer[write++]=value;
        for(int value:second)answer[write++]=value;
        return answer;
    }
}`,
          `class Solution {
    private class Fenwick(n:Int){
        private val tree=IntArray(n+1)
        fun add(start:Int){var index=start;while(index<tree.size){tree[index]++;index+=index and -index}}
        fun query(start:Int):Int{var index=start;var result=0;while(index>0){result+=tree[index];index-=index and -index};return result}
    }
    fun resultArray(nums:IntArray):IntArray{
        val sorted=nums.sortedArray()
        val first=ArrayList<Int>()
        val second=ArrayList<Int>()
        val firstTree=Fenwick(nums.size)
        val secondTree=Fenwick(nums.size)
        first.add(nums[0]);second.add(nums[1])
        firstTree.add(sorted.binarySearch(nums[0])+1)
        secondTree.add(sorted.binarySearch(nums[1])+1)
        for(index in 2 until nums.size){
            val rank=sorted.binarySearch(nums[index])+1
            val firstGreater=first.size-firstTree.query(rank)
            val secondGreater=second.size-secondTree.query(rank)
            if(firstGreater>secondGreater||firstGreater==secondGreater&&first.size<=second.size){
                first.add(nums[index]);firstTree.add(rank)
            }else{
                second.add(nums[index]);secondTree.add(rank)
            }
        }
        val answer=IntArray(nums.size)
        var write=0
        for(value in first)answer[write++]=value
        for(value in second)answer[write++]=value
        return answer
    }
}`,
          `class Solution {
    struct Fenwick{
        vector<int> tree;
        Fenwick(int n):tree(n+1){}
        void add(int index){for(;index<(int)tree.size();index+=index&-index)++tree[index];}
        int query(int index){int result=0;for(;index>0;index-=index&-index)result+=tree[index];return result;}
    };
public:
    vector<int> resultArray(vector<int>& nums){
        vector<int> sorted=nums,first{nums[0]},second{nums[1]};
        sort(sorted.begin(),sorted.end());
        Fenwick firstTree(nums.size()),secondTree(nums.size());
        auto rankOf=[&](int value){return int(lower_bound(sorted.begin(),sorted.end(),value)-sorted.begin())+1;};
        firstTree.add(rankOf(nums[0]));secondTree.add(rankOf(nums[1]));
        for(int index=2;index<(int)nums.size();++index){
            int rank=rankOf(nums[index]);
            int firstGreater=first.size()-firstTree.query(rank);
            int secondGreater=second.size()-secondTree.query(rank);
            if(firstGreater>secondGreater||(firstGreater==secondGreater&&first.size()<=second.size())){
                first.push_back(nums[index]);firstTree.add(rank);
            }else{
                second.push_back(nums[index]);secondTree.add(rank);
            }
        }
        first.insert(first.end(),second.begin(),second.end());
        return first;
    }
};`,
        ),
      ],
      tests: {
        schemaVersion: 1,
        mode: 'function',
        method: 'resultArray',
        parameterTypes: ['intArray'],
        returnType: 'intArray',
        cases: [
          { name: 'greaterCount 持平后按长度平衡重复值', args: [[2, 1, 3, 3]], expected: [2, 3, 1, 3] },
          { name: '较大元素计数使后续值连续进入第一数组', args: [[5, 14, 3, 1, 2]], expected: [5, 3, 1, 2, 14] },
          { name: '全相等元素依靠长度规则交替分配', args: [[1, 1, 1, 1, 1]], expected: [1, 1, 1, 1, 1] },
          { name: '全部 greaterCount 为零时按长度分流', args: [[10, 20, 30, 40]], expected: [10, 30, 20, 40] },
          { name: '动态计数与长度规则共同决定分配', args: [[4, 1, 3, 2, 5]], expected: [4, 3, 2, 1, 5] },
          { name: '十亿坐标与重复值完成离散化', args: [[1000000000, 1, 5, 5]], expected: [1000000000, 5, 5, 1] },
        ],
      },
    },
    {
      id: 3074,
      slug: 'apple-redistribution-into-boxes',
      title: '重新分装苹果',
      studyTags: ['数组', '贪心', '排序'],
      summary: '苹果可从原包装任意重新分配到给定容量的箱子中，求装下全部苹果所需的最少箱子数。',
      insight: '重新分装后只关心苹果总数和所选箱子的总容量。为最小化箱子数量，应始终优先选择容量最大的箱子，直到累计容量覆盖苹果总数。',
      pitfalls: ['apple 表示每包装苹果数而不是箱子容量', '苹果可以跨包装任意重分配', '只需总容量不小于苹果总数', '容量应按从大到小选择', '题目保证一定能装下全部苹果'],
      solutions: [
        solution(
          'take-largest-capacities-first',
          '优先选择最大容量',
          '汇总苹果并贪心累加最大箱子容量。',
          ['求 apple 的元素总和 remaining', '升序排序 capacity', '从最大容量开始遍历', '每选一个箱子就从 remaining 减去其容量', 'remaining 不大于零时返回已选箱子数'],
          'O(n+m log m)',
          'O(log m) 排序栈',
          `class Solution {
    public int minimumBoxes(int[] apple,int[] capacity){
        int remaining=0;
        for(int count:apple)remaining+=count;
        Arrays.sort(capacity);
        for(int index=capacity.length-1;index>=0;index--){
            remaining-=capacity[index];
            if(remaining<=0)return capacity.length-index;
        }
        return capacity.length;
    }
}`,
          `class Solution {
    fun minimumBoxes(apple:IntArray,capacity:IntArray):Int{
        var remaining=apple.sum()
        capacity.sort()
        for(index in capacity.lastIndex downTo 0){
            remaining-=capacity[index]
            if(remaining<=0)return capacity.size-index
        }
        return capacity.size
    }
}`,
          `class Solution {
public:
    int minimumBoxes(vector<int>& apple,vector<int>& capacity){
        int remaining=accumulate(apple.begin(),apple.end(),0);
        sort(capacity.rbegin(),capacity.rend());
        for(int index=0;index<(int)capacity.size();++index){
            remaining-=capacity[index];
            if(remaining<=0)return index+1;
        }
        return capacity.size();
    }
};`,
        ),
      ],
      tests: {
        schemaVersion: 1,
        mode: 'function',
        method: 'minimumBoxes',
        parameterTypes: ['intArray', 'intArray'],
        returnType: 'int',
        cases: [
          { name: '六个苹果选择两个最大箱子即可', args: [[1, 3, 2], [4, 3, 1, 5, 2]], expected: 2 },
          { name: '十五个苹果需要使用全部四个箱子', args: [[5, 5, 5], [2, 4, 2, 7]], expected: 4 },
          { name: '单个大箱子覆盖两包装苹果', args: [[3, 2], [10, 1]], expected: 1 },
          { name: '两个单位箱子缺一不可', args: [[1, 1], [1, 1]], expected: 2 },
          { name: '未排序容量中一个容量二的箱子足够', args: [[2], [1, 2, 1]], expected: 1 },
        ],
      },
    },
    {
      id: 3075,
      slug: 'maximize-happiness-of-selected-children',
      title: '幸福值最大化的选择方案',
      studyTags: ['数组', '贪心', '排序'],
      summary: '选择一个孩子后，所有尚未选择孩子的幸福值都减少一但不会低于零；恰好选择 k 个孩子，最大化所选时幸福值之和。',
      insight: '第 i 次选择时，所有仍未选择孩子都统一减少了 i。按初始幸福值从大到小选择能让每一步的基础值最大，因此第 i 个贡献为 max(0, sorted[i]-i)。',
      pitfalls: ['每次选择后只减少尚未选择的孩子', '幸福值不会降到零以下', '必须恰好选择 k 个孩子', '贡献随选择序号递减', '答案可能超过 32 位整数'],
      solutions: [
        solution(
          'descending-happiness-greedy',
          '幸福值降序贪心',
          '优先选择初始幸福值最大的孩子并扣除已发生的轮数。',
          ['升序排序 happiness', '从最大元素开始选择', '第 selected 次选择的实际贡献为 value-selected', '贡献小于零时按零计算', '累加前 k 个贡献并返回'],
          'O(n log n)',
          'O(log n) 排序栈',
          `class Solution {
    public long maximumHappinessSum(int[] happiness,int k){
        Arrays.sort(happiness);
        long answer=0;
        for(int selected=0;selected<k;selected++)answer+=Math.max(0L,(long)happiness[happiness.length-1-selected]-selected);
        return answer;
    }
}`,
          `class Solution {
    fun maximumHappinessSum(happiness:IntArray,k:Int):Long{
        happiness.sort()
        var answer=0L
        for(selected in 0 until k)answer+=maxOf(0L,happiness[happiness.lastIndex-selected].toLong()-selected)
        return answer
    }
}`,
          `class Solution {
public:
    long long maximumHappinessSum(vector<int>& happiness,int k){
        sort(happiness.rbegin(),happiness.rend());
        long long answer=0;
        for(int selected=0;selected<k;++selected)answer+=max(0LL,(long long)happiness[selected]-selected);
        return answer;
    }
};`,
        ),
      ],
      tests: {
        schemaVersion: 1,
        mode: 'function',
        method: 'maximumHappinessSum',
        parameterTypes: ['intArray', 'int'],
        returnType: 'long',
        cases: [
          { name: '选择三和二时第二个贡献减一', args: [[1, 2, 3], 2], expected: 4 },
          { name: '四个单位幸福值选择两个只有首个贡献', args: [[1, 1, 1, 1], 2], expected: 1 },
          { name: '只选择一个孩子取最大幸福值', args: [[2, 3, 4, 5], 1], expected: 5 },
          { name: '三个一亿幸福值答案接近三亿', args: [[100000000, 100000000, 100000000], 3], expected: 299999997 },
          { name: '后两个孩子幸福值衰减到零', args: [[5, 1, 1], 3], expected: 5 },
          { name: '前两大幸福值依次贡献十和八', args: [[10, 9, 8], 2], expected: 18 },
        ],
      },
    },
    {
      id: 3076,
      slug: 'shortest-uncommon-substring-in-an-array',
      title: '数组中的最短非公共子字符串',
      studyTags: ['数组', '字符串', '字典树', '枚举'],
      summary: '对每个字符串寻找不作为其他任何字符串子串出现的最短非空子串；长度相同取字典序最小，不存在则返回空串。',
      insight: '把每个字符串的所有子串插入同一棵字典树，并在每个节点记录该子串出现于多少个不同输入字符串。第二次枚举某字符串的子串时，所有者数量为一就表示它只属于当前字符串。',
      pitfalls: ['同一子串在同一字符串内出现多次只能贡献一个所有者', '只要求不出现在其他字符串中', '先最短再按字典序选择', '不存在候选时返回空字符串', '重复输入字符串会让其所有子串都不唯一'],
      solutions: [
        solution(
          'substring-trie-owner-counting',
          '子串字典树与所有者计数',
          '在共享字典树上统计每个子串属于多少个不同字符串。',
          ['建立字典树根节点', '对每个字符串和每个起点向后扩展子串', '创建或复用对应字典树节点', '借助 lastOwner 保证同一字符串只增加一次 owners', '再次枚举每个字符串的所有子串', '从 owners 为一的候选中按长度和字典序取最优', '返回答案数组'],
          'O(nL³)',
          'O(nL²)',
          `class Solution {
    private static class TrieNode{
        TrieNode[] next=new TrieNode[26];
        int owners,lastOwner=-1;
    }
    public String[] shortestSubstrings(String[] arr){
        TrieNode root=new TrieNode();
        for(int owner=0;owner<arr.length;owner++)for(int start=0;start<arr[owner].length();start++){
            TrieNode node=root;
            for(int end=start;end<arr[owner].length();end++){
                int letter=arr[owner].charAt(end)-'a';
                if(node.next[letter]==null)node.next[letter]=new TrieNode();
                node=node.next[letter];
                if(node.lastOwner!=owner){node.lastOwner=owner;node.owners++;}
            }
        }
        String[] answer=new String[arr.length];
        for(int owner=0;owner<arr.length;owner++){
            String best="";
            for(int start=0;start<arr[owner].length();start++){
                TrieNode node=root;
                for(int end=start;end<arr[owner].length();end++){
                    node=node.next[arr[owner].charAt(end)-'a'];
                    if(node.owners==1){
                        String candidate=arr[owner].substring(start,end+1);
                        if(best.isEmpty()||candidate.length()<best.length()||candidate.length()==best.length()&&candidate.compareTo(best)<0)best=candidate;
                    }
                }
            }
            answer[owner]=best;
        }
        return answer;
    }
}`,
          `class Solution {
    private class TrieNode{
        val next=arrayOfNulls<TrieNode>(26)
        var owners=0
        var lastOwner=-1
    }
    fun shortestSubstrings(arr:Array<String>):Array<String>{
        val root=TrieNode()
        for(owner in arr.indices)for(start in arr[owner].indices){
            var node=root
            for(end in start until arr[owner].length){
                val letter=arr[owner][end]-'a'
                if(node.next[letter]==null)node.next[letter]=TrieNode()
                node=node.next[letter]!!
                if(node.lastOwner!=owner){node.lastOwner=owner;node.owners++}
            }
        }
        return Array(arr.size){owner->
            var best=""
            for(start in arr[owner].indices){
                var node=root
                for(end in start until arr[owner].length){
                    node=node.next[arr[owner][end]-'a']!!
                    if(node.owners==1){
                        val candidate=arr[owner].substring(start,end+1)
                        if(best.isEmpty()||candidate.length<best.length||candidate.length==best.length&&candidate<best)best=candidate
                    }
                }
            }
            best
        }
    }
}`,
          `class Solution {
public:
    vector<string> shortestSubstrings(vector<string>& arr){
        vector<array<int,26>> next(1);
        next[0].fill(-1);
        vector<int> owners(1),lastOwner(1,-1);
        for(int owner=0;owner<(int)arr.size();++owner)for(int start=0;start<(int)arr[owner].size();++start){
            int node=0;
            for(int end=start;end<(int)arr[owner].size();++end){
                int letter=arr[owner][end]-'a';
                if(next[node][letter]==-1){
                    next[node][letter]=next.size();
                    next.push_back({});next.back().fill(-1);
                    owners.push_back(0);lastOwner.push_back(-1);
                }
                node=next[node][letter];
                if(lastOwner[node]!=owner){lastOwner[node]=owner;++owners[node];}
            }
        }
        vector<string> answer(arr.size());
        for(int owner=0;owner<(int)arr.size();++owner)for(int start=0;start<(int)arr[owner].size();++start){
            int node=0;
            for(int end=start;end<(int)arr[owner].size();++end){
                node=next[node][arr[owner][end]-'a'];
                if(owners[node]==1){
                    string candidate=arr[owner].substr(start,end-start+1);
                    if(answer[owner].empty()||candidate.size()<answer[owner].size()||(candidate.size()==answer[owner].size()&&candidate<answer[owner]))answer[owner]=candidate;
                }
            }
        }
        return answer;
    }
};`,
        ),
      ],
      tests: {
        schemaVersion: 1,
        mode: 'function',
        method: 'shortestSubstrings',
        parameterTypes: ['stringArray'],
        returnType: 'stringArray',
        cases: [
          { name: '示例同时覆盖字典序选择与不存在候选', args: [['cab', 'ad', 'bad', 'c']], expected: ['ab', '', 'ba', ''] },
          { name: '前两个字符串均被第三个完整覆盖', args: [['abc', 'bcd', 'abcd']], expected: ['', '', 'abcd'] },
          { name: '较长重复字符串只有完整串唯一', args: [['aaa', 'aa']], expected: ['aaa', ''] },
          { name: '两个不同单字符各自唯一', args: [['z', 'a']], expected: ['z', 'a'] },
          { name: '互不相交字符串各取字典序最小单字符', args: [['ab', 'cd', 'ef']], expected: ['a', 'c', 'e'] },
          { name: '两个完全相同字符串都没有唯一子串', args: [['abc', 'abc']], expected: ['', ''] },
        ],
      },
    },
    {
      id: 3077,
      slug: 'maximum-strength-of-k-disjoint-subarrays',
      title: 'K 个不相交子数组的最大能量值',
      studyTags: ['数组', '动态规划', '前缀和'],
      summary: '按顺序选择恰好 k 个非空不相交子数组，第 i 个子数组和乘以符号交替且绝对值递减的系数，求总能量最大值。',
      insight: '第 part 个子数组的固定系数为正负交替的 k-part+1。扫描数组前缀时，bestEnding 表示当前第 part 段必须在当前位置结尾的最大值，它可以延长上一位置的当前段，也可以从完成 part-1 段的前缀后新开一段。',
      pitfalls: ['必须选择恰好 k 个非空子数组', '子数组按位置顺序编号且互不重叠', '偶数编号子数组的系数为负', '相邻但不重叠的子数组合法', '数值、系数与总答案都必须使用 64 位整数'],
      solutions: [
        solution(
          'rolling-dp-by-segments-and-prefix',
          '按段数与前缀滚动 DP',
          '逐段计算在每个前缀内完成所需子数组的最大能量。',
          ['previous 初始化为选择零段时任意前缀能量为零', '从 part=1 到 k 依次处理每个子数组', '计算当前段的带符号系数', 'current 填充为负无穷', '扫描可作为当前段结尾的位置', 'bestEnding 在延长当前段与从 previous 新开一段间取最大', 'current 同时保留不使用当前位置的前缀最优值', '滚动数组并返回 previous[n]'],
          'O(nk)',
          'O(n)',
          `class Solution {
    public long maximumStrength(int[] nums,int k){
        int n=nums.length;
        long negative=Long.MIN_VALUE/4;
        long[] previous=new long[n+1];
        for(int part=1;part<=k;part++){
            long[] current=new long[n+1];
            Arrays.fill(current,negative);
            long coefficient=(long)(k-part+1)*(part%2==1?1:-1);
            long bestEnding=negative;
            for(int position=part;position<=n;position++){
                long value=coefficient*nums[position-1];
                bestEnding=Math.max(bestEnding+value,previous[position-1]+value);
                current[position]=Math.max(current[position-1],bestEnding);
            }
            previous=current;
        }
        return previous[n];
    }
}`,
          `class Solution {
    fun maximumStrength(nums:IntArray,k:Int):Long{
        val n=nums.size
        val negative=Long.MIN_VALUE/4
        var previous=LongArray(n+1)
        for(part in 1..k){
            val current=LongArray(n+1){negative}
            val coefficient=(k-part+1).toLong()*(if(part%2==1)1 else -1)
            var bestEnding=negative
            for(position in part..n){
                val value=coefficient*nums[position-1]
                bestEnding=maxOf(bestEnding+value,previous[position-1]+value)
                current[position]=maxOf(current[position-1],bestEnding)
            }
            previous=current
        }
        return previous[n]
    }
}`,
          `class Solution {
public:
    long long maximumStrength(vector<int>& nums,int k){
        int n=nums.size();
        long long negative=LLONG_MIN/4;
        vector<long long> previous(n+1);
        for(int part=1;part<=k;++part){
            vector<long long> current(n+1,negative);
            long long coefficient=(long long)(k-part+1)*(part%2?1:-1);
            long long bestEnding=negative;
            for(int position=part;position<=n;++position){
                long long value=coefficient*nums[position-1];
                bestEnding=max(bestEnding+value,previous[position-1]+value);
                current[position]=max(current[position-1],bestEnding);
            }
            previous.swap(current);
        }
        return previous[n];
    }
};`,
        ),
      ],
      tests: {
        schemaVersion: 1,
        mode: 'function',
        method: 'maximumStrength',
        parameterTypes: ['intArray', 'int'],
        returnType: 'long',
        cases: [
          { name: '三个子数组的交替系数组合得到二十二', args: [[1, 2, 3, -1, 2], 3], expected: 22 },
          { name: '选择全部五个单元素子数组得到六十四', args: [[12, -2, -2, -2, -2], 5], expected: 64 },
          { name: '只选一个子数组时退化为最大子数组和', args: [[-1, -2, -3], 1], expected: -1 },
          { name: '五元素选择三段的最大能量为三十一', args: [[5, -1, 4, -2, 3], 3], expected: 31 },
          { name: '十亿正负值的结果超过整数范围', args: [[1000000000, -1000000000, 1000000000], 3], expected: 6000000000 },
          { name: '允许段之间留出未选元素', args: [[3, -5, 2, 4, -1, 6], 3], expected: 30 },
        ],
      },
    },
  ],
}
