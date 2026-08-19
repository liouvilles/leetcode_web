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
      id: 3067,
      slug: 'count-pairs-of-connectable-servers-in-a-weighted-tree-network',
      title: '在带权树网络中统计可连接服务器对数目',
      studyTags: ['树', '深度优先搜索', '枚举', '距离'],
      summary: '对每台服务器 c，统计满足到 c 的距离都能被 signalSpeed 整除，且到 c 的两条路径没有公共边的服务器对。',
      insight: '删去中心 c 后，不同相邻边对应互不相交的分支。分别统计每个分支中到 c 距离可整除的节点数，新分支计数与此前所有分支计数之和相乘，正好得到跨分支的合法对。',
      pitfalls: ['服务器对不能包含中心 c', '两个端点必须位于 c 的不同第一层分支', '距离是边权之和而不是边数', '每个无序端点对只计一次', '路径距离应使用 long 保存'],
      solutions: [
        solution(
          'enumerate-centers-and-count-branches',
          '枚举中心并统计各分支',
          '以每个节点为中心做分支 DFS，用乘法合并不同分支的可整除节点数。',
          ['建立带权无向树', '枚举中心 server', '从中心的每个相邻节点进入一个独立分支', 'DFS 统计该分支中距离模 signalSpeed 为零的节点数', '把当前分支计数乘以前序分支总计并加入答案', '更新前序分支总计', '返回所有中心的答案'],
          'O(n²)',
          'O(n)',
          `class Solution {
    private int count(int node,int parent,long distance,int speed,List<int[]>[] graph){
        int result=distance% speed==0?1:0;
        for(int[] edge:graph[node])if(edge[0]!=parent)result+=count(edge[0],node,distance+edge[1],speed,graph);
        return result;
    }
    public int[] countPairsOfConnectableServers(int[][] edges,int signalSpeed){
        int n=edges.length+1;
        List<int[]>[] graph=new ArrayList[n];
        for(int node=0;node<n;node++)graph[node]=new ArrayList<>();
        for(int[] edge:edges){graph[edge[0]].add(new int[]{edge[1],edge[2]});graph[edge[1]].add(new int[]{edge[0],edge[2]});}
        int[] answer=new int[n];
        for(int server=0;server<n;server++){
            int previous=0;
            for(int[] edge:graph[server]){
                int current=count(edge[0],server,edge[1],signalSpeed,graph);
                answer[server]+=previous*current;
                previous+=current;
            }
        }
        return answer;
    }
}`,
          `class Solution {
    fun countPairsOfConnectableServers(edges:Array<IntArray>,signalSpeed:Int):IntArray{
        val n=edges.size+1
        val graph=Array(n){mutableListOf<IntArray>()}
        for(edge in edges){graph[edge[0]].add(intArrayOf(edge[1],edge[2]));graph[edge[1]].add(intArrayOf(edge[0],edge[2]))}
        fun count(node:Int,parent:Int,distance:Long):Int{
            var result=if(distance%signalSpeed==0L)1 else 0
            for(edge in graph[node])if(edge[0]!=parent)result+=count(edge[0],node,distance+edge[1])
            return result
        }
        val answer=IntArray(n)
        for(server in 0 until n){
            var previous=0
            for(edge in graph[server]){
                val current=count(edge[0],server,edge[1].toLong())
                answer[server]+=previous*current
                previous+=current
            }
        }
        return answer
    }
}`,
          `class Solution {
public:
    vector<int> countPairsOfConnectableServers(vector<vector<int>>& edges,int signalSpeed){
        int n=edges.size()+1;
        vector<vector<pair<int,int>>> graph(n);
        for(auto& edge:edges){graph[edge[0]].push_back({edge[1],edge[2]});graph[edge[1]].push_back({edge[0],edge[2]});}
        vector<int> answer(n);
        function<int(int,int,long long)> count=[&](int node,int parent,long long distance){
            int result=distance%signalSpeed==0;
            for(auto [next,weight]:graph[node])if(next!=parent)result+=count(next,node,distance+weight);
            return result;
        };
        for(int server=0;server<n;++server){
            int previous=0;
            for(auto [next,weight]:graph[server]){
                int current=count(next,server,weight);
                answer[server]+=previous*current;
                previous+=current;
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
        method: 'countPairsOfConnectableServers',
        parameterTypes: ['intMatrix', 'int'],
        returnType: 'intArray',
        cases: [
          { name: '两节点树没有中心可连接两个端点', args: [[[0, 1, 1]], 1], expected: [0, 0] },
          { name: '三条偶数权星形分支两两配对', args: [[[0, 1, 2], [0, 2, 4], [0, 3, 6]], 2], expected: [3, 0, 0, 0] },
          { name: '单位权四节点链的两个内部中心各有两对', args: [[[0, 1, 1], [1, 2, 1], [2, 3, 1]], 1], expected: [0, 2, 2, 0] },
          { name: '只有两条偶距离星形分支可配对', args: [[[0, 1, 1], [0, 2, 2], [0, 3, 3], [0, 4, 4]], 2], expected: [1, 0, 0, 0, 0] },
          { name: '非根节点的两个可整除分支形成一对', args: [[[0, 1, 2], [1, 2, 4], [1, 3, 3], [3, 4, 3]], 3], expected: [0, 0, 0, 1, 0] },
        ],
      },
    },
    {
      id: 3068,
      slug: 'find-the-maximum-sum-of-node-values',
      title: '最大节点价值之和',
      studyTags: ['数组', '树', '动态规划', '贪心', '位运算'],
      summary: '每次可选择树的一条边，把两个端点的值同时异或 k；经过任意次操作后求所有节点价值之和的最大值。',
      insight: '树连通，因此任意偶数个节点都能作为异或次数为奇数的端点集合，而奇数个节点不可能。把每个节点异或前后的差视为收益，只需在线性 DP 中维护已选择收益个数为偶数或奇数时的最大总收益。',
      pitfalls: ['一条边操作会同时改变两个端点', '可实现的最终异或节点数必须为偶数', 'edges 只用于保证整棵树连通', '负收益节点有时可用于修正奇偶性', '节点总和必须使用 64 位整数'],
      solutions: [
        solution(
          'even-odd-gain-dp',
          '异或收益奇偶 DP',
          '把树操作化简为选择偶数个节点获得异或收益。',
          ['计算原数组总和', 'even=0 表示选择偶数个节点的最大收益', 'odd=负无穷表示选择奇数个节点尚不可达', '遍历节点并计算 gain=(value xor k)-value', '同时更新选择或不选择当前节点后的 even 与 odd', '把最终 even 收益加到原总和', '返回结果'],
          'O(n)',
          'O(1)',
          `class Solution {
    public long maximumValueSum(int[] nums,int k,int[][] edges){
        long sum=0,even=0,odd=Long.MIN_VALUE/4;
        for(int value:nums){
            sum+=value;
            long gain=(long)(value^k)-value;
            long nextEven=Math.max(even,odd+gain);
            long nextOdd=Math.max(odd,even+gain);
            even=nextEven;
            odd=nextOdd;
        }
        return sum+even;
    }
}`,
          `class Solution {
    fun maximumValueSum(nums:IntArray,k:Int,edges:Array<IntArray>):Long{
        var sum=0L
        var even=0L
        var odd=Long.MIN_VALUE/4
        for(value in nums){
            sum+=value
            val gain=(value xor k).toLong()-value
            val nextEven=maxOf(even,odd+gain)
            val nextOdd=maxOf(odd,even+gain)
            even=nextEven
            odd=nextOdd
        }
        return sum+even
    }
}`,
          `class Solution {
public:
    long long maximumValueSum(vector<int>& nums,int k,vector<vector<int>>& edges){
        long long sum=0,even=0,odd=LLONG_MIN/4;
        for(int value:nums){
            sum+=value;
            long long gain=(value^k)-(long long)value;
            long long nextEven=max(even,odd+gain);
            long long nextOdd=max(odd,even+gain);
            even=nextEven;
            odd=nextOdd;
        }
        return sum+even;
    }
};`,
        ),
      ],
      tests: {
        schemaVersion: 1,
        mode: 'function',
        method: 'maximumValueSum',
        parameterTypes: ['intArray', 'int', 'intMatrix'],
        returnType: 'long',
        cases: [
          { name: '首尾两个节点异或后总和为六', args: [[1, 2, 1], 3, [[0, 1], [0, 2]]], expected: 6 },
          { name: '两节点同时异或七得到九', args: [[2, 3], 7, [[0, 1]]], expected: 9 },
          { name: '所有异或收益为负时不执行操作', args: [[7, 7, 7, 7], 1, [[0, 1], [1, 2], [2, 3]]], expected: 28 },
          { name: '三个正收益只能选择其中偶数个', args: [[0, 1, 2], 4, [[0, 1], [1, 2]]], expected: 11 },
          { name: '十亿级节点和与收益超过整数范围', args: [[1000000000, 1000000000, 1000000000, 1000000000, 1000000000], 1, [[0, 1], [1, 2], [2, 3], [3, 4]]], expected: 5000000004 },
        ],
      },
    },
    {
      id: 3069,
      slug: 'distribute-elements-into-two-arrays-i',
      title: '将元素分配到两个数组中 I',
      studyTags: ['数组', '模拟'],
      summary: '以 nums[0] 和 nums[1] 分别初始化两个数组；之后比较两数组末尾元素，把当前值追加到末尾值更大的数组，最后连接两数组。',
      insight: '规则只依赖两个数组当前的最后一个元素，不需要保存额外状态。用两个顺序容器模拟追加，处理完后按 arr1、arr2 的顺序写入答案。',
      pitfalls: ['前两个元素分别进入不同数组', '比较的是末尾元素而不是最大元素', '若 arr1 末尾不大于 arr2 末尾则进入 arr2', '最终结果是 arr1 后接 arr2', '官方约束保证 nums 中元素互不相同'],
      solutions: [
        solution(
          'simulate-two-array-tails',
          '模拟两个数组的末尾',
          '按定义维护两个数组并在最后连接。',
          ['用 nums[0] 初始化 first', '用 nums[1] 初始化 second', '从 nums[2] 开始遍历', '比较 first 与 second 的末尾元素', '把当前元素追加到末尾更大的数组', '依次复制 first 和 second 到结果', '返回结果'],
          'O(n)',
          'O(n)',
          `class Solution {
    public int[] resultArray(int[] nums){
        int n=nums.length;
        int[] first=new int[n],second=new int[n];
        int firstSize=1,secondSize=1;
        first[0]=nums[0];second[0]=nums[1];
        for(int index=2;index<n;index++){
            if(first[firstSize-1]>second[secondSize-1])first[firstSize++]=nums[index];
            else second[secondSize++]=nums[index];
        }
        int[] answer=new int[n];
        System.arraycopy(first,0,answer,0,firstSize);
        System.arraycopy(second,0,answer,firstSize,secondSize);
        return answer;
    }
}`,
          `class Solution {
    fun resultArray(nums:IntArray):IntArray{
        val first=IntArray(nums.size)
        val second=IntArray(nums.size)
        var firstSize=1
        var secondSize=1
        first[0]=nums[0];second[0]=nums[1]
        for(index in 2 until nums.size){
            if(first[firstSize-1]>second[secondSize-1])first[firstSize++]=nums[index]
            else second[secondSize++]=nums[index]
        }
        val answer=IntArray(nums.size)
        for(index in 0 until firstSize)answer[index]=first[index]
        for(index in 0 until secondSize)answer[firstSize+index]=second[index]
        return answer
    }
}`,
          `class Solution {
public:
    vector<int> resultArray(vector<int>& nums){
        vector<int> first{nums[0]},second{nums[1]};
        for(int index=2;index<(int)nums.size();++index){
            if(first.back()>second.back())first.push_back(nums[index]);
            else second.push_back(nums[index]);
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
          { name: '第三个元素进入末尾较大的第一数组', args: [[2, 1, 3]], expected: [2, 3, 1] },
          { name: '末尾比较在处理中发生变化', args: [[5, 4, 3, 8]], expected: [5, 3, 4, 8] },
          { name: '递增数组后续元素全部进入第二数组', args: [[1, 2, 3, 4]], expected: [1, 2, 3, 4] },
          { name: '五个互异元素按动态末尾分配', args: [[3, 8, 2, 7, 5]], expected: [3, 7, 5, 8, 2] },
          { name: '第一数组连续接收多个元素', args: [[10, 1, 5, 6, 2]], expected: [10, 5, 6, 2, 1] },
        ],
      },
    },
    {
      id: 3070,
      slug: 'count-submatrices-with-top-left-element-and-sum-less-than-k',
      title: '元素和小于等于 k 的子矩阵的数目',
      studyTags: ['数组', '矩阵', '前缀和'],
      summary: '统计以 grid[0][0] 为左上角、元素和不超过 k 的非空子矩阵数目。',
      insight: '每个候选子矩阵由右下角唯一确定。逐行累加每列从第零行到当前行的列和，再对这些列和做横向前缀，就能用 O(n) 额外空间得到所有右下角对应的矩形和。',
      pitfalls: ['所有子矩阵都必须包含左上角 grid[0][0]', '条件是元素和小于等于 k', '网格元素非负但无需提前停止扫描', '行列规模都可到一千', '前缀和使用 long 更稳妥'],
      solutions: [
        solution(
          'rolling-column-prefix-sums',
          '滚动列和与横向前缀',
          '用一维列和依次计算每个右下角对应的二维前缀和。',
          ['建立长度为列数的 columnSums', '逐行扫描网格', '把当前格加入对应 columnSums', '在当前行从左到右累计 columnSums', '累计值就是以当前格为右下角的子矩阵和', '若累计值不超过 k 则答案加一', '返回答案'],
          'O(mn)',
          'O(n)',
          `class Solution {
    public int countSubmatrices(int[][] grid,int k){
        long[] columnSums=new long[grid[0].length];
        int answer=0;
        for(int[] row:grid){
            long prefix=0;
            for(int column=0;column<row.length;column++){
                columnSums[column]+=row[column];
                prefix+=columnSums[column];
                if(prefix<=k)answer++;
            }
        }
        return answer;
    }
}`,
          `class Solution {
    fun countSubmatrices(grid:Array<IntArray>,k:Int):Int{
        val columnSums=LongArray(grid[0].size)
        var answer=0
        for(row in grid){
            var prefix=0L
            for(column in row.indices){
                columnSums[column]+=row[column]
                prefix+=columnSums[column]
                if(prefix<=k)answer++
            }
        }
        return answer
    }
}`,
          `class Solution {
public:
    int countSubmatrices(vector<vector<int>>& grid,int k){
        vector<long long> columnSums(grid[0].size());
        int answer=0;
        for(auto& row:grid){
            long long prefix=0;
            for(int column=0;column<(int)row.size();++column){
                columnSums[column]+=row[column];
                prefix+=columnSums[column];
                answer+=prefix<=k;
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
        method: 'countSubmatrices',
        parameterTypes: ['intMatrix', 'int'],
        returnType: 'int',
        cases: [
          { name: '六个候选中四个前缀矩形和不超过十八', args: [[[7, 6, 3], [6, 6, 1]], 18], expected: 4 },
          { name: '三乘三网格共有六个合格前缀矩形', args: [[[7, 2, 9], [1, 5, 0], [2, 6, 6]], 20], expected: 6 },
          { name: '单个零元素小于阈值', args: [[[0]], 1], expected: 1 },
          { name: '唯一元素超过阈值时答案为零', args: [[[5]], 4], expected: 0 },
          { name: '右下角完整矩阵和恰好等于阈值', args: [[[1, 2], [3, 4]], 10], expected: 4 },
        ],
      },
    },
    {
      id: 3071,
      slug: 'minimum-operations-to-write-the-letter-y-on-a-grid',
      title: '在矩阵上写出字母 Y 所需的最少操作次数',
      studyTags: ['数组', '矩阵', '计数', '枚举'],
      summary: '奇数阶矩阵只含 0、1、2；要让字母 Y 覆盖格使用同一数值、其余格使用另一个不同数值，求最少改单元格次数。',
      insight: '每个格子只属于 Y 或非 Y 两类。分别统计两类中三种数值的频次，再枚举 Y 使用的值和背景使用的不同值，保留频次之和最大的一组即可。',
      pitfalls: ['Y 的上半部分包含两条对角线直到中心', '中心以下只包含中间列', 'Y 与背景必须使用不同数值', '每次操作可把一个格改成 0、1、2 中任意值', '只需枚举六种有序配色'],
      solutions: [
        solution(
          'count-y-and-background-colors',
          '统计 Y 与背景颜色',
          '将格子按是否属于 Y 分组计数并枚举两组的不同目标值。',
          ['计算中心下标 middle', '遍历所有格子判断是否属于 Y', '分别累计 yCount 与 backgroundCount', '枚举 Y 的目标值', '枚举与它不同的背景目标值', '总格数减去两类可保留格数得到修改次数', '返回最小修改次数'],
          'O(n²)',
          'O(1)',
          `class Solution {
    public int minimumOperationsToWriteY(int[][] grid){
        int n=grid.length,middle=n/2;
        int[] yCount=new int[3],backgroundCount=new int[3];
        int ySize=0;
        for(int row=0;row<n;row++)for(int column=0;column<n;column++){
            boolean onY=row<=middle?(column==row||column==n-1-row):column==middle;
            if(onY){yCount[grid[row][column]]++;ySize++;}
            else backgroundCount[grid[row][column]]++;
        }
        int answer=n*n;
        for(int y=0;y<3;y++)for(int background=0;background<3;background++)if(y!=background){
            answer=Math.min(answer,ySize-yCount[y]+(n*n-ySize)-backgroundCount[background]);
        }
        return answer;
    }
}`,
          `class Solution {
    fun minimumOperationsToWriteY(grid:Array<IntArray>):Int{
        val n=grid.size
        val middle=n/2
        val yCount=IntArray(3)
        val backgroundCount=IntArray(3)
        var ySize=0
        for(row in 0 until n)for(column in 0 until n){
            val onY=if(row<=middle)column==row||column==n-1-row else column==middle
            if(onY){yCount[grid[row][column]]++;ySize++}else backgroundCount[grid[row][column]]++
        }
        var answer=n*n
        for(y in 0..2)for(background in 0..2)if(y!=background){
            answer=minOf(answer,ySize-yCount[y]+(n*n-ySize)-backgroundCount[background])
        }
        return answer
    }
}`,
          `class Solution {
public:
    int minimumOperationsToWriteY(vector<vector<int>>& grid){
        int n=grid.size(),middle=n/2,ySize=0,answer=n*n;
        int yCount[3]={},backgroundCount[3]={};
        for(int row=0;row<n;++row)for(int column=0;column<n;++column){
            bool onY=row<=middle?(column==row||column==n-1-row):column==middle;
            if(onY){++yCount[grid[row][column]];++ySize;}else ++backgroundCount[grid[row][column]];
        }
        for(int y=0;y<3;++y)for(int background=0;background<3;++background)if(y!=background){
            answer=min(answer,ySize-yCount[y]+n*n-ySize-backgroundCount[background]);
        }
        return answer;
    }
};`,
        ),
      ],
      tests: {
        schemaVersion: 1,
        mode: 'function',
        method: 'minimumOperationsToWriteY',
        parameterTypes: ['intMatrix'],
        returnType: 'int',
        cases: [
          { name: '三阶示例最少修改三个格子', args: [[[1, 2, 2], [1, 1, 0], [0, 1, 0]]], expected: 3 },
          { name: '全零矩阵至少要修改四个 Y 格', args: [[[0, 0, 0], [0, 0, 0], [0, 0, 0]]], expected: 4 },
          { name: '数值二的 Y 与零背景已经合法', args: [[[2, 0, 2], [0, 2, 0], [0, 2, 0]]], expected: 0 },
          { name: '五阶合法配色各有一个错位格', args: [[[2, 2, 1, 1, 0], [1, 0, 1, 0, 1], [1, 1, 0, 1, 1], [1, 1, 0, 1, 1], [1, 1, 0, 1, 1]]], expected: 2 },
          { name: '三种颜色混合时最佳配色需修改五格', args: [[[0, 1, 0], [2, 1, 2], [0, 1, 0]]], expected: 5 },
        ],
      },
    },
  ],
}
