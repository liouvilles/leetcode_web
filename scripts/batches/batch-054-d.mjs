const solution = (id, title, idea, steps, time, space, java, kotlin, cpp) => ({
  id,
  title,
  kind: '最优',
  idea,
  steps,
  complexity: { time, space },
  code: { java, kotlin, cpp },
})

const alternatingStress = Array.from({ length: 8000 }, (_, index) => index & 1)

export default {
  batchId: 'batch-054',
  problems: [
    {
      id: 3098,
      slug: 'find-the-sum-of-subsequence-powers',
      title: '求出所有子序列的能量和',
      studyTags: ['数组', '排序', '动态规划', '枚举'],
      summary: '长度为 k 的子序列能量等于其中任意两元素绝对差的最小值；求 nums 所有长度 k 子序列的能量和并取模。',
      insight: '排序后，子序列的最小两两差一定出现在相邻选中元素之间。对每个可能的正差 d，动态规划统计相邻差都至少为 d 的长度 k 子序列数 F(d)；能量恰为 d 的数量是 F(d) 减去下一个更大候选差的 F。',
      pitfalls: ['子序列保留选择顺序但排序不改变元素组合', '最小两两差可化为排序后相邻选中元素的最小差', '重复元素产生零能量且无需贡献答案', '不同候选差必须去重并升序处理', '计数和贡献都要持续对 1e9+7 取模'],
      solutions: [
        solution(
          'threshold-counting-dp-over-distinct-differences',
          '候选差阈值计数 DP',
          '统计能量至少为每个候选差的子序列数，再相邻做差得到精确分布。',
          ['排序 nums', '收集所有正的两两差并去重升序', '对每个差 d 计算 F(d)', 'DP 的 previous[i] 表示固定长度且以 i 结尾的方案数', '用前缀和与单调指针找到所有可接在 i 前的元素', '用 F(d)-F(next d) 得到能量恰为 d 的方案数', '累加 d 乘方案数并取模'],
          'O(n³k)',
          'O(n²)',
          `class Solution {
    private static final long MOD=1000000007L;
    private long countAtLeast(int[] nums,int k,int difference){
        int n=nums.length;
        long[] previous=new long[n];
        Arrays.fill(previous,1);
        for(int length=2;length<=k;length++){
            long[] prefix=new long[n],current=new long[n];
            long sum=0;
            for(int index=0;index<n;index++){sum=(sum+previous[index])%MOD;prefix[index]=sum;}
            int pointer=-1;
            for(int index=0;index<n;index++){
                while(pointer+1<index&&(long)nums[index]-nums[pointer+1]>=difference)pointer++;
                if(pointer>=0)current[index]=prefix[pointer];
            }
            previous=current;
        }
        long result=0;
        for(long count:previous)result=(result+count)%MOD;
        return result;
    }
    public int sumOfPowers(int[] nums,int k){
        Arrays.sort(nums);
        TreeSet<Integer> set=new TreeSet<>();
        for(int left=0;left<nums.length;left++)for(int right=left+1;right<nums.length;right++)if(nums[right]>nums[left])set.add(nums[right]-nums[left]);
        int[] differences=new int[set.size()];
        int write=0;
        for(int difference:set)differences[write++]=difference;
        long[] counts=new long[differences.length];
        for(int index=0;index<differences.length;index++)counts[index]=countAtLeast(nums,k,differences[index]);
        long answer=0;
        for(int index=0;index<differences.length;index++){
            long next=index+1<differences.length?counts[index+1]:0;
            long exact=(counts[index]-next+MOD)%MOD;
            answer=(answer+(differences[index]%MOD)*exact)%MOD;
        }
        return (int)answer;
    }
}`,
          `class Solution {
    private val mod=1000000007L
    private fun countAtLeast(nums:IntArray,k:Int,difference:Int):Long{
        val n=nums.size
        var previous=LongArray(n){1L}
        for(length in 2..k){
            val prefix=LongArray(n)
            val current=LongArray(n)
            var sum=0L
            for(index in 0 until n){sum=(sum+previous[index])%mod;prefix[index]=sum}
            var pointer=-1
            for(index in 0 until n){
                while(pointer+1<index&&nums[index].toLong()-nums[pointer+1]>=difference)pointer++
                if(pointer>=0)current[index]=prefix[pointer]
            }
            previous=current
        }
        var result=0L
        for(count in previous)result=(result+count)%mod
        return result
    }
    fun sumOfPowers(nums:IntArray,k:Int):Int{
        nums.sort()
        val set=java.util.TreeSet<Int>()
        for(left in nums.indices)for(right in left+1 until nums.size)if(nums[right]>nums[left])set.add(nums[right]-nums[left])
        val differences=set.toList()
        val counts=LongArray(differences.size){countAtLeast(nums,k,differences[it])}
        var answer=0L
        for(index in differences.indices){
            val next=if(index+1<counts.size)counts[index+1] else 0L
            val exact=(counts[index]-next+mod)%mod
            answer=(answer+differences[index].toLong()%mod*exact)%mod
        }
        return answer.toInt()
    }
}`,
          `class Solution {
    static constexpr long long MOD=1000000007LL;
    long long countAtLeast(const vector<int>& nums,int k,int difference){
        int n=nums.size();
        vector<long long> previous(n,1);
        for(int length=2;length<=k;++length){
            vector<long long> prefix(n),current(n);
            long long sum=0;
            for(int index=0;index<n;++index){sum=(sum+previous[index])%MOD;prefix[index]=sum;}
            int pointer=-1;
            for(int index=0;index<n;++index){
                while(pointer+1<index&&(long long)nums[index]-nums[pointer+1]>=difference)++pointer;
                if(pointer>=0)current[index]=prefix[pointer];
            }
            previous.swap(current);
        }
        return accumulate(previous.begin(),previous.end(),0LL)%MOD;
    }
public:
    int sumOfPowers(vector<int>& nums,int k){
        sort(nums.begin(),nums.end());
        set<int> uniqueDifferences;
        for(int left=0;left<(int)nums.size();++left)for(int right=left+1;right<(int)nums.size();++right)if(nums[right]>nums[left])uniqueDifferences.insert(nums[right]-nums[left]);
        vector<int> differences(uniqueDifferences.begin(),uniqueDifferences.end());
        vector<long long> counts;
        for(int difference:differences)counts.push_back(countAtLeast(nums,k,difference));
        long long answer=0;
        for(int index=0;index<(int)differences.size();++index){
            long long next=index+1<(int)counts.size()?counts[index+1]:0;
            long long exact=(counts[index]-next+MOD)%MOD;
            answer=(answer+differences[index]%MOD*exact)%MOD;
        }
        return answer;
    }
};`,
        ),
      ],
      tests: {
        schemaVersion: 1,
        mode: 'function',
        method: 'sumOfPowers',
        parameterTypes: ['intArray', 'int'],
        returnType: 'int',
        cases: [
          { name: '四个连续数的四个三元素子序列能量均为一', args: [[1, 2, 3, 4], 3], expected: 4 },
          { name: '两个重复元素的唯一子序列能量为零', args: [[2, 2], 2], expected: 0 },
          { name: '三个数所有二元素子序列差值和为十', args: [[4, 3, -1], 2], expected: 10 },
          { name: '重复一与三形成两个差二的子序列', args: [[1, 1, 3], 2], expected: 4 },
          { name: '选择全部元素时能量为最小相邻差四', args: [[1, 5, 9], 3], expected: 4 },
          { name: '两端极值的能量为二亿', args: [[-100000000, 100000000], 2], expected: 200000000 },
        ],
      },
    },
    {
      id: 3099,
      slug: 'harshad-number',
      title: '哈沙德数',
      studyTags: ['数学', '模拟'],
      summary: '若正整数 x 能被其十进制各位数字之和整除，则返回该数字和；否则返回负一。',
      insight: '保留原数用于整除判断，同时反复取个位并去掉个位即可得到数字和。x 至少为一，因此数字和不会为零。',
      pitfalls: ['整除的是原始 x', '返回值是数字和而不是 x', '非哈沙德数返回 -1', 'x=100 的数字和为一'],
      solutions: [
        solution(
          'digit-sum-and-divisibility-check',
          '数位和与整除判断',
          '线性提取十进制数位后检查原数取模。',
          ['保存 original=x', '初始化 digitSum=0', '循环累加 x%10', '令 x/=10 去掉最低位', '若 original%digitSum 为零则返回 digitSum', '否则返回 -1'],
          'O(log x)',
          'O(1)',
          `class Solution { public int sumOfTheDigitsOfHarshadNumber(int x){int original=x,digitSum=0;while(x>0){digitSum+=x%10;x/=10;}return original%digitSum==0?digitSum:-1;} }`,
          `class Solution { fun sumOfTheDigitsOfHarshadNumber(x:Int):Int{var value=x;var digitSum=0;while(value>0){digitSum+=value%10;value/=10};return if(x%digitSum==0)digitSum else -1} }`,
          `class Solution { public:int sumOfTheDigitsOfHarshadNumber(int x){int original=x,digitSum=0;while(x){digitSum+=x%10;x/=10;}return original%digitSum==0?digitSum:-1;} };`,
        ),
      ],
      tests: {
        schemaVersion: 1,
        mode: 'function',
        method: 'sumOfTheDigitsOfHarshadNumber',
        parameterTypes: ['int'],
        returnType: 'int',
        cases: [
          { name: '十八能被数位和九整除', args: [18], expected: 9 },
          { name: '二十三不能被数位和五整除', args: [23], expected: -1 },
          { name: '一百的数位和为一', args: [100], expected: 1 },
          { name: '一是最小哈沙德数', args: [1], expected: 1 },
          { name: '十一不能被二整除', args: [11], expected: -1 },
        ],
      },
    },
    {
      id: 3100,
      slug: 'water-bottles-ii',
      title: '换水问题 II',
      studyTags: ['数学', '模拟'],
      summary: '喝完满瓶水会得到空瓶；每次用当前 numExchange 个空瓶换一瓶满水后，兑换所需空瓶数增加一，求最多能喝多少瓶。',
      insight: '先喝完所有初始满瓶。只要空瓶数达到当前兑换门槛，就兑换一瓶并立刻喝掉：空瓶先减少门槛，再因喝完新水增加一个，同时门槛加一。',
      pitfalls: ['兑换门槛在每次兑换后增加一', '新换来的水喝完会再产生一个空瓶', '一次只兑换一瓶', '门槛为一时第一次兑换后不会无限循环'],
      solutions: [
        solution(
          'simulate-increasing-exchange-cost',
          '模拟递增兑换门槛',
          '维护空瓶数、已喝瓶数和下一次兑换成本。',
          ['drunk 与 empty 都初始化为 numBottles', '当 empty>=numExchange 时继续', '支付 numExchange 个空瓶', '喝掉换来的满瓶使 drunk 与 empty 各加一', '令 numExchange 加一', '返回 drunk'],
          'O(√n)',
          'O(1)',
          `class Solution { public int maxBottlesDrunk(int numBottles,int numExchange){int drunk=numBottles,empty=numBottles;while(empty>=numExchange){empty-=numExchange;empty++;drunk++;numExchange++;}return drunk;} }`,
          `class Solution { fun maxBottlesDrunk(numBottles:Int,numExchange:Int):Int{var exchange=numExchange;var drunk=numBottles;var empty=numBottles;while(empty>=exchange){empty-=exchange;empty++;drunk++;exchange++};return drunk} }`,
          `class Solution { public:int maxBottlesDrunk(int numBottles,int numExchange){int drunk=numBottles,empty=numBottles;while(empty>=numExchange){empty-=numExchange;++empty;++drunk;++numExchange;}return drunk;} };`,
        ),
      ],
      tests: {
        schemaVersion: 1,
        mode: 'function',
        method: 'maxBottlesDrunk',
        parameterTypes: ['int', 'int'],
        returnType: 'int',
        cases: [
          { name: '十三瓶从门槛六开始可再换两瓶', args: [13, 6], expected: 15 },
          { name: '十瓶从门槛三开始可再换三瓶', args: [10, 3], expected: 13 },
          { name: '一瓶且初始门槛一时可额外换一瓶', args: [1, 1], expected: 2 },
          { name: '空瓶不足初始门槛时不能兑换', args: [5, 10], expected: 5 },
          { name: '一百瓶从门槛一开始共喝一百一十四瓶', args: [100, 1], expected: 114 },
          { name: '两个空瓶按门槛二恰好换一次', args: [2, 2], expected: 3 },
        ],
      },
    },
    {
      id: 3101,
      slug: 'count-alternating-subarrays',
      title: '交替子数组计数',
      studyTags: ['数组', '动态规划', '计数'],
      summary: '二进制数组的交替子数组要求所有相邻元素不同；统计全部非空交替子数组。',
      insight: '令 ending 表示以当前位置结尾的交替子数组数量。若当前值与前一值不同，所有此前结尾方案都能延长并加上单元素方案，ending 加一；否则只能重新从单元素开始。',
      pitfalls: ['单元素子数组总是交替', '相邻相等会把当前连续长度重置为一', '不同交替区间的贡献可逐位置累加', '长度十万的答案会超过 32 位'],
      solutions: [
        solution(
          'alternating-run-ending-count',
          '交替连续段结尾计数',
          '累计每个位置可作为右端点的交替子数组数量。',
          ['ending=1 处理首元素', 'answer 初始化为一', '从第二个元素开始扫描', '相邻不同则 ending++', '相邻相同则 ending=1', '把 ending 加入 answer', '返回 64 位答案'],
          'O(n)',
          'O(1)',
          `class Solution { public long countAlternatingSubarrays(int[] nums){long answer=1,ending=1;for(int index=1;index<nums.length;index++){ending=nums[index]!=nums[index-1]?ending+1:1;answer+=ending;}return answer;} }`,
          `class Solution { fun countAlternatingSubarrays(nums:IntArray):Long{var answer=1L;var ending=1L;for(index in 1 until nums.size){ending=if(nums[index]!=nums[index-1])ending+1 else 1;answer+=ending};return answer} }`,
          `class Solution { public:long long countAlternatingSubarrays(vector<int>& nums){long long answer=1,ending=1;for(int index=1;index<(int)nums.size();++index){ending=nums[index]!=nums[index-1]?ending+1:1;answer+=ending;}return answer;} };`,
        ),
      ],
      tests: {
        schemaVersion: 1,
        mode: 'function',
        method: 'countAlternatingSubarrays',
        parameterTypes: ['intArray'],
        returnType: 'long',
        cases: [
          { name: '零一后连续相等共有五个交替子数组', args: [[0, 1, 1, 1]], expected: 5 },
          { name: '四元素完全交替包含十个子数组', args: [[1, 0, 1, 0]], expected: 10 },
          { name: '单元素只有自身一个子数组', args: [[1]], expected: 1 },
          { name: '三个相同元素只有三个单元素子数组', args: [[0, 0, 0]], expected: 3 },
          { name: '八千元素完全交替形成三千二百万个子数组', args: [alternatingStress], expected: 32004000 },
        ],
      },
    },
    {
      id: 3102,
      slug: 'minimize-manhattan-distances',
      title: '最小化曼哈顿距离',
      studyTags: ['数组', '数学', '几何', '极值'],
      summary: '从平面点集中恰好移除一个点，使剩余任意两点曼哈顿距离的最大值尽可能小，返回该最小最大距离。',
      insight: '曼哈顿直径等于 max(max(x+y)-min(x+y), max(x-y)-min(x-y))。只有当前四个变换极值点的移除可能缩小直径；枚举这些至多四个下标并重算剩余极值即可在线性时间完成。',
      pitfalls: ['必须恰好移除一个点', '曼哈顿距离用 x+y 与 x-y 两个方向刻画', '极值可能由多个重复点共同取得', '移除非极值点不会改变当前直径', '坐标变换仍在 32 位有符号整数范围内'],
      solutions: [
        solution(
          'try-four-transformed-extreme-points',
          '枚举四个变换极值点',
          '只尝试删除 x+y 与 x-y 的最小或最大值所在点。',
          ['扫描所有点记录 x+y 的最小与最大下标', '同时记录 x-y 的最小与最大下标', '把四个下标作为候选删除点', '对每个候选重新扫描其余点的两个变换范围', '取两个范围的最大值作为删除后的直径', '返回所有候选直径的最小值'],
          'O(n)',
          'O(1)',
          `class Solution {
    public int minimumDistance(int[][] points){
        int minSum=Integer.MAX_VALUE,maxSum=Integer.MIN_VALUE,minDifference=Integer.MAX_VALUE,maxDifference=Integer.MIN_VALUE;
        int minSumIndex=0,maxSumIndex=0,minDifferenceIndex=0,maxDifferenceIndex=0;
        for(int index=0;index<points.length;index++){
            int sum=points[index][0]+points[index][1],difference=points[index][0]-points[index][1];
            if(sum<minSum){minSum=sum;minSumIndex=index;}if(sum>maxSum){maxSum=sum;maxSumIndex=index;}
            if(difference<minDifference){minDifference=difference;minDifferenceIndex=index;}if(difference>maxDifference){maxDifference=difference;maxDifferenceIndex=index;}
        }
        int answer=Integer.MAX_VALUE;
        int[] candidates={minSumIndex,maxSumIndex,minDifferenceIndex,maxDifferenceIndex};
        for(int removed:candidates){
            int lowSum=Integer.MAX_VALUE,highSum=Integer.MIN_VALUE,lowDifference=Integer.MAX_VALUE,highDifference=Integer.MIN_VALUE;
            for(int index=0;index<points.length;index++)if(index!=removed){
                int sum=points[index][0]+points[index][1],difference=points[index][0]-points[index][1];
                lowSum=Math.min(lowSum,sum);highSum=Math.max(highSum,sum);
                lowDifference=Math.min(lowDifference,difference);highDifference=Math.max(highDifference,difference);
            }
            answer=Math.min(answer,Math.max(highSum-lowSum,highDifference-lowDifference));
        }
        return answer;
    }
}`,
          `class Solution {
    fun minimumDistance(points:Array<IntArray>):Int{
        var minSum=Int.MAX_VALUE;var maxSum=Int.MIN_VALUE;var minDifference=Int.MAX_VALUE;var maxDifference=Int.MIN_VALUE
        var minSumIndex=0;var maxSumIndex=0;var minDifferenceIndex=0;var maxDifferenceIndex=0
        for(index in points.indices){
            val sum=points[index][0]+points[index][1];val difference=points[index][0]-points[index][1]
            if(sum<minSum){minSum=sum;minSumIndex=index};if(sum>maxSum){maxSum=sum;maxSumIndex=index}
            if(difference<minDifference){minDifference=difference;minDifferenceIndex=index};if(difference>maxDifference){maxDifference=difference;maxDifferenceIndex=index}
        }
        var answer=Int.MAX_VALUE
        for(removed in intArrayOf(minSumIndex,maxSumIndex,minDifferenceIndex,maxDifferenceIndex)){
            var lowSum=Int.MAX_VALUE;var highSum=Int.MIN_VALUE;var lowDifference=Int.MAX_VALUE;var highDifference=Int.MIN_VALUE
            for(index in points.indices)if(index!=removed){
                val sum=points[index][0]+points[index][1];val difference=points[index][0]-points[index][1]
                lowSum=minOf(lowSum,sum);highSum=maxOf(highSum,sum);lowDifference=minOf(lowDifference,difference);highDifference=maxOf(highDifference,difference)
            }
            answer=minOf(answer,maxOf(highSum-lowSum,highDifference-lowDifference))
        }
        return answer
    }
}`,
          `class Solution {
public:
    int minimumDistance(vector<vector<int>>& points){
        int minSum=INT_MAX,maxSum=INT_MIN,minDifference=INT_MAX,maxDifference=INT_MIN;
        int minSumIndex=0,maxSumIndex=0,minDifferenceIndex=0,maxDifferenceIndex=0;
        for(int index=0;index<(int)points.size();++index){
            int sum=points[index][0]+points[index][1],difference=points[index][0]-points[index][1];
            if(sum<minSum){minSum=sum;minSumIndex=index;}if(sum>maxSum){maxSum=sum;maxSumIndex=index;}
            if(difference<minDifference){minDifference=difference;minDifferenceIndex=index;}if(difference>maxDifference){maxDifference=difference;maxDifferenceIndex=index;}
        }
        int answer=INT_MAX;
        for(int removed:{minSumIndex,maxSumIndex,minDifferenceIndex,maxDifferenceIndex}){
            int lowSum=INT_MAX,highSum=INT_MIN,lowDifference=INT_MAX,highDifference=INT_MIN;
            for(int index=0;index<(int)points.size();++index)if(index!=removed){
                int sum=points[index][0]+points[index][1],difference=points[index][0]-points[index][1];
                lowSum=min(lowSum,sum);highSum=max(highSum,sum);lowDifference=min(lowDifference,difference);highDifference=max(highDifference,difference);
            }
            answer=min(answer,max(highSum-lowSum,highDifference-lowDifference));
        }
        return answer;
    }
};`,
        ),
      ],
      tests: {
        schemaVersion: 1,
        mode: 'function',
        method: 'minimumDistance',
        parameterTypes: ['intMatrix'],
        returnType: 'int',
        cases: [
          { name: '四点示例删除一个极值后最小直径十二', args: [[[3, 10], [5, 15], [10, 2], [4, 4]]], expected: 12 },
          { name: '三个重复点移除任意一点距离仍为零', args: [[[1, 1], [1, 1], [1, 1]]], expected: 0 },
          { name: '删除远端点后两个近点距离为二', args: [[[1, 1], [2, 2], [100, 100]]], expected: 2 },
          { name: '正方形删除一个角后仍有距离四的对角点', args: [[[1, 1], [1, 3], [3, 1], [3, 3]]], expected: 4 },
          { name: '同水平线删除十后剩余直径二', args: [[[1, 1], [2, 1], [3, 1], [10, 1]]], expected: 2 },
          { name: '一亿坐标边界删除孤立小点后距离一', args: [[[1, 1], [100000000, 100000000], [99999999, 100000000]]], expected: 1 },
        ],
      },
    },
  ],
}
