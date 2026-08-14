const makeSolution = (id, title, kind, idea, steps, time, space, java, kotlin, cpp) => ({
  id,
  title,
  kind,
  idea,
  steps,
  complexity: { time, space },
  code: { java, kotlin, cpp },
})

export default {
  batchId: 'batch-001',
  problems: [
    {
      id: 146,
      slug: 'lru-cache',
      title: 'LRU 缓存',
      studyTags: ['哈希表', '双向链表', '最近使用顺序'],
      summary: '设计固定容量的键值缓存，使查询和更新都能在常数时间完成；容量满时淘汰最久未使用的键。',
      insight: '哈希表负责按键定位节点，双向链表负责在常数时间移动节点并维护新旧顺序。',
      pitfalls: ['读取已有键也会刷新最近使用时间', '更新已有键不能增加缓存大小', '淘汰节点后必须同步从哈希表删除'],
      solutions: [
        makeSolution(
          'linked-hash-map',
          '访问顺序映射',
          '最优',
          '利用语言标准库中按访问顺序维护的有序映射，在插入后主动淘汰最旧条目。',
          ['创建 accessOrder 模式的 LinkedHashMap', 'get 直接读取并自动刷新顺序', 'put 后若超容量则删除迭代器指向的最旧键'],
          'O(1)',
          'O(capacity)',
          `class Solution {
    public int[] process(int capacity, int[][] operations) {
        LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>(16, 0.75f, true);
        List<Integer> output = new ArrayList<>();
        for (int[] operation : operations) {
            if (operation[0] == 0) {
                output.add(cache.getOrDefault(operation[1], -1));
            } else {
                cache.put(operation[1], operation[2]);
                if (cache.size() > capacity) {
                    Integer oldest = cache.keySet().iterator().next();
                    cache.remove(oldest);
                }
            }
        }
        return output.stream().mapToInt(Integer::intValue).toArray();
    }
}`,
          `class Solution {
    fun process(capacity: Int, operations: Array<IntArray>): IntArray {
        val cache = object : LinkedHashMap<Int, Int>(16, 0.75f, true) {}
        val output = ArrayList<Int>()
        for (operation in operations) {
            if (operation[0] == 0) {
                output.add(cache[operation[1]] ?: -1)
            } else {
                cache[operation[1]] = operation[2]
                if (cache.size > capacity) cache.remove(cache.keys.first())
            }
        }
        return output.toIntArray()
    }
}`,
          `class Solution {
public:
    vector<int> process(int capacity, vector<vector<int>>& operations) {
        list<pair<int, int>> order;
        unordered_map<int, list<pair<int, int>>::iterator> positions;
        vector<int> output;
        for (const auto& operation : operations) {
            int key = operation[1];
            if (operation[0] == 0) {
                auto found = positions.find(key);
                if (found == positions.end()) output.push_back(-1);
                else {
                    order.splice(order.begin(), order, found->second);
                    output.push_back(found->second->second);
                }
            } else {
                auto found = positions.find(key);
                if (found != positions.end()) {
                    found->second->second = operation[2];
                    order.splice(order.begin(), order, found->second);
                } else {
                    order.push_front({key, operation[2]});
                    positions[key] = order.begin();
                    if ((int)positions.size() > capacity) {
                        positions.erase(order.back().first);
                        order.pop_back();
                    }
                }
            }
        }
        return output;
    }
};`,
        ),
      ],
      tests: {
        schemaVersion: 1,
        mode: 'function',
        method: 'process',
        parameterTypes: ['int', 'intMatrix'],
        returnType: 'intArray',
        cases: [
          { name: '读取刷新顺序并淘汰最旧项', args: [2, [[1, 1, 1], [1, 2, 2], [0, 1], [1, 3, 3], [0, 2], [1, 4, 4], [0, 1], [0, 3], [0, 4]]], expected: [1, -1, -1, 3, 4] },
          { name: '更新已有键不占用新容量', args: [2, [[1, 2, 1], [1, 2, 2], [0, 2]]], expected: [2] },
          { name: '容量一持续淘汰', args: [1, [[1, 1, 10], [1, 2, 20], [0, 1], [0, 2]]], expected: [-1, 20] },
        ],
      },
    },
    {
      id: 152,
      slug: 'maximum-product-subarray',
      title: '乘积最大子数组',
      studyTags: ['动态规划', '最大最小状态', '负数翻转'],
      summary: '在整数数组中寻找乘积最大的非空连续子数组，并返回该最大乘积。',
      insight: '负数会交换最大值和最小值的角色，因此每个位置必须同时维护以它结尾的最大乘积与最小乘积。',
      pitfalls: ['不能只维护最大乘积', '遇到零时当前状态会自然重启', '更新最小值时必须使用上一轮的最大值'],
      solutions: [
        makeSolution(
          'max-min-dp',
          '最大最小双状态',
          '最优',
          '对每个新元素比较独立开始、乘以前一最大值、乘以前一最小值三种选择。',
          ['初始化最大、最小和答案为首元素', '保存上一轮状态后计算三个候选值', '分别更新当前最大、最小以及全局答案'],
          'O(n)',
          'O(1)',
          `class Solution {
    public int maxProduct(int[] nums) {
        int currentMax = nums[0], currentMin = nums[0], answer = nums[0];
        for (int index = 1; index < nums.length; index++) {
            int value = nums[index];
            int previousMax = currentMax;
            currentMax = Math.max(value, Math.max(previousMax * value, currentMin * value));
            currentMin = Math.min(value, Math.min(previousMax * value, currentMin * value));
            answer = Math.max(answer, currentMax);
        }
        return answer;
    }
}`,
          `class Solution {
    fun maxProduct(nums: IntArray): Int {
        var currentMax = nums[0]
        var currentMin = nums[0]
        var answer = nums[0]
        for (index in 1 until nums.size) {
            val value = nums[index]
            val previousMax = currentMax
            currentMax = maxOf(value, previousMax * value, currentMin * value)
            currentMin = minOf(value, previousMax * value, currentMin * value)
            answer = maxOf(answer, currentMax)
        }
        return answer
    }
}`,
          `class Solution {
public:
    int maxProduct(vector<int>& nums) {
        int currentMax = nums[0], currentMin = nums[0], answer = nums[0];
        for (int index = 1; index < (int)nums.size(); ++index) {
            int value = nums[index], previousMax = currentMax;
            currentMax = max({value, previousMax * value, currentMin * value});
            currentMin = min({value, previousMax * value, currentMin * value});
            answer = max(answer, currentMax);
        }
        return answer;
    }
};`,
        ),
      ],
      tests: {
        schemaVersion: 1,
        mode: 'function',
        method: 'maxProduct',
        parameterTypes: ['intArray'],
        returnType: 'int',
        cases: [
          { name: '两个正数形成最大乘积', args: [[2, 3, -2, 4]], expected: 6 },
          { name: '零切断连续区间', args: [[-2, 0, -1]], expected: 0 },
          { name: '两个负数翻转为正数', args: [[-2, 3, -4]], expected: 24 },
        ],
      },
    },
    {
      id: 169,
      slug: 'majority-element',
      title: '多数元素',
      studyTags: ['Boyer-Moore', '投票抵消', '常数空间'],
      summary: '找出数组中出现次数严格超过一半的元素，题目保证这样的元素一定存在。',
      insight: '把多数元素与其他元素两两抵消，多数元素最终仍会留下，因此只需维护一个候选值和票数。',
      pitfalls: ['票数归零后当前元素应成为新候选', '抵消过程依赖多数元素必然存在的前提', '候选值变化不代表之前的统计需要回溯'],
      solutions: [
        makeSolution(
          'boyer-moore-voting',
          'Boyer-Moore 投票',
          '最优',
          '相同元素给候选加票，不同元素减票，票数清零时更换候选。',
          ['票数为零时把当前值设为候选', '当前值等于候选则加一，否则减一', '遍历结束后候选即为多数元素'],
          'O(n)',
          'O(1)',
          `class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0, votes = 0;
        for (int value : nums) {
            if (votes == 0) candidate = value;
            votes += value == candidate ? 1 : -1;
        }
        return candidate;
    }
}`,
          `class Solution {
    fun majorityElement(nums: IntArray): Int {
        var candidate = 0
        var votes = 0
        for (value in nums) {
            if (votes == 0) candidate = value
            votes += if (value == candidate) 1 else -1
        }
        return candidate
    }
}`,
          `class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int candidate = 0, votes = 0;
        for (int value : nums) {
            if (votes == 0) candidate = value;
            votes += value == candidate ? 1 : -1;
        }
        return candidate;
    }
};`,
        ),
      ],
      tests: {
        schemaVersion: 1,
        mode: 'function',
        method: 'majorityElement',
        parameterTypes: ['intArray'],
        returnType: 'int',
        cases: [
          { name: '三个元素中的多数', args: [[3, 2, 3]], expected: 3 },
          { name: '候选值多次变化', args: [[2, 2, 1, 1, 1, 2, 2]], expected: 2 },
          { name: '单元素数组', args: [[1]], expected: 1 },
        ],
      },
    },
    {
      id: 198,
      slug: 'house-robber',
      title: '打家劫舍',
      studyTags: ['动态规划', '相邻互斥', '滚动状态'],
      summary: '从一排房屋中选择若干间获取金额，但不能选择相邻房屋，求能够获得的最大总金额。',
      insight: '处理当前房屋时只有两种最优选择：跳过它继承上一状态，或选择它并加上隔一间之前的最优值。',
      pitfalls: ['选择当前房屋时不能使用上一间的状态', '金额可以为零', '两个滚动变量更新时要保留旧值含义'],
      solutions: [
        makeSolution(
          'rolling-dp',
          '滚动动态规划',
          '最优',
          '用 previous 表示到前一间的最优值，beforePrevious 表示到前两间的最优值。',
          ['初始化两个历史状态为零', '当前最优取跳过与选择当前房屋的较大值', '滚动更新历史状态'],
          'O(n)',
          'O(1)',
          `class Solution {
    public int rob(int[] nums) {
        int beforePrevious = 0, previous = 0;
        for (int money : nums) {
            int current = Math.max(previous, beforePrevious + money);
            beforePrevious = previous;
            previous = current;
        }
        return previous;
    }
}`,
          `class Solution {
    fun rob(nums: IntArray): Int {
        var beforePrevious = 0
        var previous = 0
        for (money in nums) {
            val current = maxOf(previous, beforePrevious + money)
            beforePrevious = previous
            previous = current
        }
        return previous
    }
}`,
          `class Solution {
public:
    int rob(vector<int>& nums) {
        int beforePrevious = 0, previous = 0;
        for (int money : nums) {
            int current = max(previous, beforePrevious + money);
            beforePrevious = previous;
            previous = current;
        }
        return previous;
    }
};`,
        ),
      ],
      tests: {
        schemaVersion: 1,
        mode: 'function',
        method: 'rob',
        parameterTypes: ['intArray'],
        returnType: 'int',
        cases: [
          { name: '选择首尾两间', args: [[1, 2, 3, 1]], expected: 4 },
          { name: '跳过中间相邻选择', args: [[2, 7, 9, 3, 1]], expected: 12 },
          { name: '单间房屋', args: [[5]], expected: 5 },
        ],
      },
    },
    {
      id: 207,
      slug: 'course-schedule',
      title: '课程表',
      studyTags: ['拓扑排序', '入度', '环检测'],
      summary: '课程之间存在先修关系，判断能否完成全部课程；若依赖关系形成有向环则无法完成。',
      insight: '不断移除入度为零的课程；若最终所有课程都被移除，依赖图就是无环图。',
      pitfalls: ['关系 [a,b] 表示 b 指向 a', '同一课程可能解锁多个后续课程', '最终判断应比较已处理课程数而不是队列是否曾经非空'],
      solutions: [
        makeSolution(
          'kahn-topological-sort',
          'Kahn 拓扑排序',
          '最优',
          '建立邻接表和入度数组，从所有零入度课程开始逐层删除依赖边。',
          ['统计每门课程入度并建立后继列表', '把所有零入度课程加入队列', '弹出课程、减少后继入度并统计已完成数量'],
          'O(V + E)',
          'O(V + E)',
          `class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int course = 0; course < numCourses; course++) graph.add(new ArrayList<>());
        int[] indegree = new int[numCourses];
        for (int[] edge : prerequisites) {
            graph.get(edge[1]).add(edge[0]);
            indegree[edge[0]]++;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int course = 0; course < numCourses; course++) if (indegree[course] == 0) queue.offer(course);
        int completed = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            completed++;
            for (int next : graph.get(course)) if (--indegree[next] == 0) queue.offer(next);
        }
        return completed == numCourses;
    }
}`,
          `class Solution {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val graph = List(numCourses) { ArrayList<Int>() }
        val indegree = IntArray(numCourses)
        for (edge in prerequisites) {
            graph[edge[1]].add(edge[0])
            indegree[edge[0]]++
        }
        val queue: ArrayDeque<Int> = ArrayDeque()
        for (course in 0 until numCourses) if (indegree[course] == 0) queue.add(course)
        var completed = 0
        while (queue.isNotEmpty()) {
            val course = queue.removeFirst()
            completed++
            for (next in graph[course]) {
                indegree[next]--
                if (indegree[next] == 0) queue.add(next)
            }
        }
        return completed == numCourses
    }
}`,
          `class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        vector<vector<int>> graph(numCourses);
        vector<int> indegree(numCourses);
        for (const auto& edge : prerequisites) {
            graph[edge[1]].push_back(edge[0]);
            ++indegree[edge[0]];
        }
        queue<int> pending;
        for (int course = 0; course < numCourses; ++course) if (indegree[course] == 0) pending.push(course);
        int completed = 0;
        while (!pending.empty()) {
            int course = pending.front(); pending.pop();
            ++completed;
            for (int next : graph[course]) if (--indegree[next] == 0) pending.push(next);
        }
        return completed == numCourses;
    }
};`,
        ),
      ],
      tests: {
        schemaVersion: 1,
        mode: 'function',
        method: 'canFinish',
        parameterTypes: ['int', 'intMatrix'],
        returnType: 'boolean',
        cases: [
          { name: '单向依赖无环', args: [2, [[1, 0]]], expected: true },
          { name: '两门课程互相依赖', args: [2, [[1, 0], [0, 1]]], expected: false },
          { name: '多条依赖组成有向无环图', args: [4, [[1, 0], [2, 0], [3, 1], [3, 2]]], expected: true },
        ],
      },
    },
  ],
}
