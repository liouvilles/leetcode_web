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
  batchId: 'batch-054',
  problems: [
    {
      id: 3105,
      slug: 'longest-strictly-increasing-or-strictly-decreasing-subarray',
      title: '最长的严格递增或递减子数组',
      studyTags: ['数组', '动态规划'],
      summary: '求 nums 中严格递增或严格递减的连续非空子数组的最大长度。',
      insight: '扫描到当前位置时，只需维护以它结尾的严格递增长度和严格递减长度。根据与前一元素的大小关系延长对应方向，另一个方向重置为一；相等时两者都重置。',
      pitfalls: ['要求连续子数组而不是子序列', '递增和递减都必须严格', '相等元素会同时打断两个方向', '单元素答案为一'],
      solutions: [
        solution(
          'track-increasing-and-decreasing-runs',
          '维护双向单调连续段',
          '在线更新以每个位置结尾的递增与递减子数组长度。',
          ['increasing=decreasing=answer=1', '从第二个元素开始扫描', '当前值更大时延长 increasing 并重置 decreasing', '当前值更小时延长 decreasing 并重置 increasing', '相等时两者都重置为一', '用两者更新 answer', '返回 answer'],
          'O(n)',
          'O(1)',
          `class Solution { public int longestMonotonicSubarray(int[] nums){int increasing=1,decreasing=1,answer=1;for(int index=1;index<nums.length;index++){if(nums[index]>nums[index-1]){increasing++;decreasing=1;}else if(nums[index]<nums[index-1]){decreasing++;increasing=1;}else increasing=decreasing=1;answer=Math.max(answer,Math.max(increasing,decreasing));}return answer;} }`,
          `class Solution { fun longestMonotonicSubarray(nums:IntArray):Int{var increasing=1;var decreasing=1;var answer=1;for(index in 1 until nums.size){if(nums[index]>nums[index-1]){increasing++;decreasing=1}else if(nums[index]<nums[index-1]){decreasing++;increasing=1}else{increasing=1;decreasing=1};answer=maxOf(answer,increasing,decreasing)};return answer} }`,
          `class Solution { public:int longestMonotonicSubarray(vector<int>& nums){int increasing=1,decreasing=1,answer=1;for(int index=1;index<(int)nums.size();++index){if(nums[index]>nums[index-1]){++increasing;decreasing=1;}else if(nums[index]<nums[index-1]){++decreasing;increasing=1;}else increasing=decreasing=1;answer=max({answer,increasing,decreasing});}return answer;} };`,
        ),
      ],
      tests: {
        schemaVersion: 1,
        mode: 'function',
        method: 'longestMonotonicSubarray',
        parameterTypes: ['intArray'],
        returnType: 'int',
        cases: [
          { name: '相等元素切断后最长单调段为二', args: [[1, 4, 3, 3, 2]], expected: 2 },
          { name: '完整严格递减数组长度为三', args: [[3, 2, 1]], expected: 3 },
          { name: '完整严格递增数组长度为四', args: [[1, 2, 3, 4]], expected: 4 },
          { name: '所有元素相等时答案为一', args: [[2, 2, 2]], expected: 1 },
          { name: '单元素数组答案为一', args: [[1]], expected: 1 },
          { name: '先上升后形成长度四的下降段', args: [[1, 3, 2, 1, 0]], expected: 4 },
        ],
      },
    },
    {
      id: 3106,
      slug: 'lexicographically-smallest-string-after-operations-with-constraint',
      title: '满足距离约束且字典序最小的字符串',
      studyTags: ['字符串', '贪心'],
      summary: '小写字母按环形字母表定义距离；在新字符串与 s 的逐位距离总和不超过 k 时，求字典序最小的新字符串。',
      insight: '字典序由最靠前的不同位置决定，因此从左到右尽量把每个字符变成 a。若剩余预算不足以到 a，就把该字符沿普通字母序向前移动全部剩余步数并结束预算。',
      pitfalls: ['a 与 z 的距离为一', '总距离预算由所有位置共享', '应优先优化更靠左的位置', '到 a 的成本是向前与环绕向后的较小值', '预算可以不全部使用'],
      solutions: [
        solution(
          'left-to-right-cyclic-distance-greedy',
          '从左到右消耗环形距离',
          '逐字符优先变成 a，无法到 a 时把剩余预算用于当前字符。',
          ['把 s 转为字符数组', '从左到右遍历字符', '计算当前字符到 a 的环形最短距离', '预算足够则写成 a 并扣除距离', '预算不足则把字符向字母序前方移动剩余步数', '清空预算并结束后续修改', '返回字符数组构成的字符串'],
          'O(n)',
          'O(n)',
          `class Solution { public String getSmallestString(String s,int k){char[] letters=s.toCharArray();for(int index=0;index<letters.length&&k>0;index++){int direct=letters[index]-'a',distance=Math.min(direct,26-direct);if(distance<=k){letters[index]='a';k-=distance;}else{letters[index]=(char)(letters[index]-k);k=0;}}return new String(letters);} }`,
          `class Solution { fun getSmallestString(s:String,k:Int):String{val letters=s.toCharArray();var remaining=k;for(index in letters.indices){if(remaining==0)break;val direct=letters[index]-'a';val distance=minOf(direct,26-direct);if(distance<=remaining){letters[index]='a';remaining-=distance}else{letters[index]=(letters[index].code-remaining).toChar();remaining=0}};return letters.concatToString()} }`,
          `class Solution { public:string getSmallestString(string s,int k){for(char& letter:s){if(k==0)break;int direct=letter-'a',distance=min(direct,26-direct);if(distance<=k){letter='a';k-=distance;}else{letter-=k;k=0;}}return s;} };`,
        ),
      ],
      tests: {
        schemaVersion: 1,
        mode: 'function',
        method: 'getSmallestString',
        parameterTypes: ['string', 'int'],
        returnType: 'string',
        cases: [
          { name: '三个预算依次把 zbb 变成 aaa', args: ['zbbz', 3], expected: 'aaaz' },
          { name: '先环绕把 x 变 a 再把下一 x 前移一', args: ['xaxcd', 4], expected: 'aawcd' },
          { name: '零预算保持原字符串', args: ['lol', 0], expected: 'lol' },
          { name: '充足预算把所有字符变成 a', args: ['abc', 100], expected: 'aaa' },
          { name: 'n 到 a 需十三步而十二步只能到 b', args: ['n', 12], expected: 'b' },
          { name: 'y 的一步预算向前变成 x', args: ['y', 1], expected: 'x' },
        ],
      },
    },
    {
      id: 3107,
      slug: 'minimum-operations-to-make-median-of-array-equal-to-k',
      title: '使数组中位数等于 K 的最少操作数',
      studyTags: ['数组', '贪心', '排序'],
      summary: '每次可把任一元素增加或减少一；按排序后下标 floor(n/2) 定义中位数，求使中位数等于 k 的最少操作数。',
      insight: '排序后，若中位数高于 k，只需把中位数及其左侧所有高于 k 的值降到 k；若低于 k，只需把中位数及其右侧所有低于 k 的值升到 k。其他元素不会妨碍中位数位置。',
      pitfalls: ['偶数长度使用排序后下标 n/2 的较大中位数', '修改代价是数值差的绝对值', '左半部分只需处理高于 k 的值', '右半部分只需处理低于 k 的值', '总代价可能超过 32 位'],
      solutions: [
        solution(
          'sort-and-adjust-around-median',
          '排序后调整中位数两侧',
          '只修改会迫使中位数越过 k 的元素。',
          ['排序 nums', '令 middle=n/2', '扫描下标不大于 middle 的元素', '把其中高于 k 的部分下降代价加入答案', '扫描下标不小于 middle 的元素', '把其中低于 k 的部分上升代价加入答案', '返回 64 位代价'],
          'O(n log n)',
          'O(log n) 排序栈',
          `class Solution { public long minOperationsToMakeMedianK(int[] nums,int k){Arrays.sort(nums);int middle=nums.length/2;long answer=0;for(int index=0;index<=middle;index++)if(nums[index]>k)answer+=(long)nums[index]-k;for(int index=middle;index<nums.length;index++)if(nums[index]<k)answer+=(long)k-nums[index];return answer;} }`,
          `class Solution { fun minOperationsToMakeMedianK(nums:IntArray,k:Int):Long{nums.sort();val middle=nums.size/2;var answer=0L;for(index in 0..middle)if(nums[index]>k)answer+=nums[index].toLong()-k;for(index in middle until nums.size)if(nums[index]<k)answer+=k.toLong()-nums[index];return answer} }`,
          `class Solution { public:long long minOperationsToMakeMedianK(vector<int>& nums,int k){sort(nums.begin(),nums.end());int middle=nums.size()/2;long long answer=0;for(int index=0;index<=middle;++index)if(nums[index]>k)answer+=(long long)nums[index]-k;for(int index=middle;index<(int)nums.size();++index)if(nums[index]<k)answer+=(long long)k-nums[index];return answer;} };`,
        ),
      ],
      tests: {
        schemaVersion: 1,
        mode: 'function',
        method: 'minOperationsToMakeMedianK',
        parameterTypes: ['intArray', 'int'],
        returnType: 'long',
        cases: [
          { name: '两个五各下降一使中位数变四', args: [[2, 5, 6, 8, 5], 4], expected: 2 },
          { name: '五和六共上升三使中位数变七', args: [[2, 5, 6, 8, 5], 7], expected: 3 },
          { name: '偶数长度采用较大中位数并下降一', args: [[1, 2, 3, 4], 2], expected: 1 },
          { name: '单元素已等于目标无需操作', args: [[1], 1], expected: 0 },
          { name: '五个十亿元素需修改三个值到一', args: [[1000000000, 1000000000, 1000000000, 1000000000, 1000000000], 1], expected: 2999999997 },
          { name: '目标已是当前中位数时答案为零', args: [[7, 1, 5, 3, 9], 5], expected: 0 },
        ],
      },
    },
    {
      id: 3108,
      slug: 'minimum-cost-walk-in-weighted-graph',
      title: '带权图里旅途的最小代价',
      studyTags: ['数组', '图', '并查集', '位运算'],
      summary: '无向图中一次旅途可重复经过顶点和边，其代价是沿途所有边权的按位与；对每个不同端点查询求最小代价，不可达返回负一。',
      insight: '同一连通分量内可以从起点绕行覆盖分量中的所有边，再到达终点；重复边不会改变按位与。因此任意可达的不同端点对的最小代价都等于该连通分量全部边权的按位与。',
      pitfalls: ['walk 允许重复顶点和边', '按位与加入更多边只会清除比特', '同一分量内所有查询答案相同', '不同连通分量之间返回 -1', '边权可以为零且可能有重边'],
      solutions: [
        solution(
          'union-find-component-edge-and',
          '并查集合并分量边权',
          '先确定连通分量，再计算每个分量全部边权的按位与。',
          ['初始化并查集', '遍历所有边并合并两个端点', 'componentCost 以 -1 初始化', '再次遍历边，把边权按位与到最终根的 componentCost', '逐个处理查询', '根不同则写 -1', '根相同则写该分量的 componentCost'],
          'O((n+m+q) α(n))',
          'O(n)',
          `class Solution {
    private static class UnionFind{
        int[] parent,size;
        UnionFind(int n){parent=new int[n];size=new int[n];for(int node=0;node<n;node++){parent[node]=node;size[node]=1;}}
        int find(int node){if(parent[node]!=node)parent[node]=find(parent[node]);return parent[node];}
        void union(int first,int second){int a=find(first),b=find(second);if(a==b)return;if(size[a]<size[b]){int temporary=a;a=b;b=temporary;}parent[b]=a;size[a]+=size[b];}
    }
    public int[] minimumCost(int n,int[][] edges,int[][] query){
        UnionFind unionFind=new UnionFind(n);
        for(int[] edge:edges)unionFind.union(edge[0],edge[1]);
        int[] componentCost=new int[n];
        Arrays.fill(componentCost,-1);
        for(int[] edge:edges){int root=unionFind.find(edge[0]);componentCost[root]&=edge[2];}
        int[] answer=new int[query.length];
        for(int index=0;index<query.length;index++){
            int first=unionFind.find(query[index][0]),second=unionFind.find(query[index][1]);
            answer[index]=first==second?componentCost[first]:-1;
        }
        return answer;
    }
}`,
          `class Solution {
    private class UnionFind(n:Int){
        private val parent=IntArray(n){it}
        private val size=IntArray(n){1}
        fun find(node:Int):Int{if(parent[node]!=node)parent[node]=find(parent[node]);return parent[node]}
        fun union(first:Int,second:Int){var a=find(first);var b=find(second);if(a==b)return;if(size[a]<size[b]){val temporary=a;a=b;b=temporary};parent[b]=a;size[a]+=size[b]}
    }
    fun minimumCost(n:Int,edges:Array<IntArray>,query:Array<IntArray>):IntArray{
        val unionFind=UnionFind(n)
        for(edge in edges)unionFind.union(edge[0],edge[1])
        val componentCost=IntArray(n){-1}
        for(edge in edges){val root=unionFind.find(edge[0]);componentCost[root]=componentCost[root] and edge[2]}
        return IntArray(query.size){index->
            val first=unionFind.find(query[index][0]);val second=unionFind.find(query[index][1])
            if(first==second)componentCost[first] else -1
        }
    }
}`,
          `class Solution {
    struct UnionFind{
        vector<int> parent,size;
        UnionFind(int n):parent(n),size(n,1){iota(parent.begin(),parent.end(),0);}
        int find(int node){return parent[node]==node?node:parent[node]=find(parent[node]);}
        void unite(int first,int second){int a=find(first),b=find(second);if(a==b)return;if(size[a]<size[b])swap(a,b);parent[b]=a;size[a]+=size[b];}
    };
public:
    vector<int> minimumCost(int n,vector<vector<int>>& edges,vector<vector<int>>& query){
        UnionFind unionFind(n);
        for(auto& edge:edges)unionFind.unite(edge[0],edge[1]);
        vector<int> componentCost(n,-1);
        for(auto& edge:edges)componentCost[unionFind.find(edge[0])]&=edge[2];
        vector<int> answer;
        for(auto& item:query){int first=unionFind.find(item[0]),second=unionFind.find(item[1]);answer.push_back(first==second?componentCost[first]:-1);}
        return answer;
    }
};`,
        ),
      ],
      tests: {
        schemaVersion: 1,
        mode: 'function',
        method: 'minimumCost',
        parameterTypes: ['int', 'intMatrix', 'intMatrix'],
        returnType: 'intArray',
        cases: [
          { name: '同一分量绕行低权边得到一而孤立点不可达', args: [5, [[0, 1, 7], [1, 3, 7], [1, 2, 1]], [[0, 3], [3, 4]]], expected: [1, -1] },
          { name: '两个连通分量分别取全部边权按位与', args: [5, [[0, 1, 6], [1, 2, 3], [3, 4, 7]], [[0, 2], [0, 1], [3, 4], [2, 4]]], expected: [2, 2, 7, -1] },
          { name: '分量含零权边后任意查询代价为零', args: [3, [[0, 1, 5], [1, 2, 0]], [[0, 2], [0, 1]]], expected: [0, 0] },
          { name: '两条重边共同把分量代价降到三', args: [2, [[0, 1, 7], [0, 1, 3]], [[0, 1]]], expected: [3] },
          { name: '没有边时不同孤立节点不可达', args: [3, [], [[0, 1], [1, 2]]], expected: [-1, -1] },
        ],
      },
    },
    {
      id: 3110,
      slug: 'score-of-a-string',
      title: '字符串的分数',
      studyTags: ['字符串', '模拟'],
      summary: '字符串分数为所有相邻字符 ASCII 值差的绝对值之和，返回该分数。',
      insight: '逐对扫描相邻字符，将字符编码相减后取绝对值并累加即可。小写字母相邻差最多二十五，整数范围充足。',
      pitfalls: ['只计算相邻字符对', '差值必须取绝对值', '长度 n 的字符串有 n-1 对', '字符相同贡献零'],
      solutions: [
        solution(
          'sum-adjacent-character-differences',
          '累加相邻字符差',
          '一次扫描计算每对相邻字符编码差的绝对值。',
          ['answer=0', '从第二个字符开始遍历', '计算当前字符与前一字符编码之差', '取绝对值加入 answer', '返回 answer'],
          'O(n)',
          'O(1)',
          `class Solution { public int scoreOfString(String s){int answer=0;for(int index=1;index<s.length();index++)answer+=Math.abs(s.charAt(index)-s.charAt(index-1));return answer;} }`,
          `class Solution { fun scoreOfString(s:String):Int{var answer=0;for(index in 1 until s.length)answer+=kotlin.math.abs(s[index].code-s[index-1].code);return answer} }`,
          `class Solution { public:int scoreOfString(string s){int answer=0;for(int index=1;index<(int)s.size();++index)answer+=abs(s[index]-s[index-1]);return answer;} };`,
        ),
      ],
      tests: {
        schemaVersion: 1,
        mode: 'function',
        method: 'scoreOfString',
        parameterTypes: ['string'],
        returnType: 'int',
        cases: [
          { name: 'hello 的相邻字符差总和为十三', args: ['hello'], expected: 13 },
          { name: 'zaz 两次跨越二十五总分五十', args: ['zaz'], expected: 50 },
          { name: '两个相同字符得分为零', args: ['aa'], expected: 0 },
          { name: '连续字母 abc 得分为二', args: ['abc'], expected: 2 },
          { name: 'azby 的三段字符差总和七十二', args: ['azby'], expected: 72 },
        ],
      },
    },
  ],
}
