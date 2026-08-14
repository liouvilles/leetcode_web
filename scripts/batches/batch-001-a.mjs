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
      id: 2,
      slug: 'add-two-numbers',
      title: '两数相加',
      studyTags: ['链表模拟加法', '进位处理', '虚拟头结点'],
      summary: '两个非空链表按低位到高位保存两个非负整数，逐位相加并以同样的逆序链表形式返回结果。',
      insight: '链表节点正好按个位到高位排列，可以像手算加法一样同步前进，并把进位带到下一轮。',
      pitfalls: ['两个链表长度可能不同', '最后一次进位可能产生额外节点', '输入中的前导零规则不等于结果可以丢弃末尾进位'],
      solutions: [
        makeSolution(
          'iterative-carry',
          '同步遍历与进位',
          '最优',
          '用两个指针逐位读取数字，当前位之和加上 carry 后生成新节点。',
          ['建立虚拟头结点保存结果', '读取两个当前位置，不存在的节点按 0 处理', '写入个位并更新进位，直到节点与进位全部耗尽'],
          'O(max(m, n))',
          'O(max(m, n))',
          `class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if (l1 != null) { sum += l1.val; l1 = l1.next; }
            if (l2 != null) { sum += l2.val; l2 = l2.next; }
            tail.next = new ListNode(sum % 10);
            tail = tail.next;
            carry = sum / 10;
        }
        return dummy.next;
    }
}`,
          `class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val dummy = ListNode(0)
        var tail = dummy
        var first = l1
        var second = l2
        var carry = 0
        while (first != null || second != null || carry != 0) {
            val sum = carry + (first?.\`val\` ?: 0) + (second?.\`val\` ?: 0)
            tail.next = ListNode(sum % 10)
            tail = tail.next!!
            carry = sum / 10
            first = first?.next
            second = second?.next
        }
        return dummy.next
    }
}`,
          `class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode dummy;
        ListNode* tail = &dummy;
        int carry = 0;
        while (l1 || l2 || carry) {
            int sum = carry;
            if (l1) { sum += l1->val; l1 = l1->next; }
            if (l2) { sum += l2->val; l2 = l2->next; }
            tail->next = new ListNode(sum % 10);
            tail = tail->next;
            carry = sum / 10;
        }
        return dummy.next;
    }
};`,
        ),
      ],
      tests: {
        schemaVersion: 1,
        mode: 'function',
        method: 'addTwoNumbers',
        parameterTypes: ['listNode', 'listNode'],
        returnType: 'listNode',
        cases: [
          { name: '普通三位数相加', args: [[2, 4, 3], [5, 6, 4]], expected: [7, 0, 8] },
          { name: '两个零相加', args: [[0], [0]], expected: [0] },
          { name: '连续进位且长度不同', args: [[9, 9, 9, 9, 9, 9, 9], [9, 9, 9, 9]], expected: [8, 9, 9, 9, 0, 0, 0, 1] },
        ],
      },
    },
    {
      id: 5,
      slug: 'longest-palindromic-substring',
      title: '最长回文子串',
      studyTags: ['中心扩展', '奇偶中心', '区间更新'],
      summary: '在给定字符串中寻找长度最大的连续回文片段，并返回其中任意一个最长答案。',
      insight: '每个回文串都能由一个字符中心或两个字符之间的中心向两侧同步扩展得到。',
      pitfalls: ['子串必须连续', '需要分别处理奇数长度和偶数长度中心', '多个最长答案同时存在时返回任意一个即可'],
      solutions: [
        makeSolution(
          'expand-around-center',
          '中心扩展',
          '最优',
          '枚举 2n-1 个可能的回文中心，向两侧扩展并记录最长边界。',
          ['对每个位置尝试单字符中心', '再尝试相邻双字符中心', '仅在得到更长回文时更新左右边界'],
          'O(n²)',
          'O(1)',
          `class Solution {
    public String longestPalindrome(String s) {
        int left = 0, right = 0;
        for (int center = 0; center < s.length(); center++) {
            int length = Math.max(expand(s, center, center), expand(s, center, center + 1));
            if (length > right - left + 1) {
                left = center - (length - 1) / 2;
                right = center + length / 2;
            }
        }
        return s.substring(left, right + 1);
    }

    private int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}`,
          `class Solution {
    fun longestPalindrome(s: String): String {
        var bestLeft = 0
        var bestRight = 0
        for (center in s.indices) {
            val length = maxOf(expand(s, center, center), expand(s, center, center + 1))
            if (length > bestRight - bestLeft + 1) {
                bestLeft = center - (length - 1) / 2
                bestRight = center + length / 2
            }
        }
        return s.substring(bestLeft, bestRight + 1)
    }

    private fun expand(s: String, startLeft: Int, startRight: Int): Int {
        var left = startLeft
        var right = startRight
        while (left >= 0 && right < s.length && s[left] == s[right]) {
            left--
            right++
        }
        return right - left - 1
    }
}`,
          `class Solution {
    int expand(const string& s, int left, int right) {
        while (left >= 0 && right < (int)s.size() && s[left] == s[right]) {
            --left;
            ++right;
        }
        return right - left - 1;
    }
public:
    string longestPalindrome(string s) {
        int bestLeft = 0, bestRight = 0;
        for (int center = 0; center < (int)s.size(); ++center) {
            int length = max(expand(s, center, center), expand(s, center, center + 1));
            if (length > bestRight - bestLeft + 1) {
                bestLeft = center - (length - 1) / 2;
                bestRight = center + length / 2;
            }
        }
        return s.substr(bestLeft, bestRight - bestLeft + 1);
    }
};`,
        ),
      ],
      tests: {
        schemaVersion: 1,
        mode: 'function',
        method: 'longestPalindrome',
        parameterTypes: ['string'],
        returnType: 'string',
        cases: [
          { name: '存在两个等长答案时保留先发现者', args: ['babad'], expected: 'bab' },
          { name: '偶数长度回文', args: ['cbbd'], expected: 'bb' },
          { name: '单字符字符串', args: ['a'], expected: 'a' },
        ],
      },
    },
    {
      id: 11,
      slug: 'container-with-most-water',
      title: '盛最多水的容器',
      studyTags: ['双指针', '短板效应', '排除不可能区间'],
      summary: '数组中的每个高度代表一条竖线，选择两条竖线与横轴组成容器，求能够容纳的最大水量。',
      insight: '面积由较短边决定；向内移动较长边只会缩小宽度，因此只有移动短边才可能改善答案。',
      pitfalls: ['面积使用两端距离而不是元素个数', '每轮应移动较短的一侧', '相等高度时移动任意一侧都不会漏解'],
      solutions: [
        makeSolution(
          'two-pointers',
          '相向双指针',
          '最优',
          '从最宽区间开始，根据短板高度排除不可能产生更优解的一端。',
          ['左右指针放在数组两端', '用宽度乘两端较小高度更新答案', '移动高度较小的指针'],
          'O(n)',
          'O(1)',
          `class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, best = 0;
        while (left < right) {
            best = Math.max(best, (right - left) * Math.min(height[left], height[right]));
            if (height[left] <= height[right]) left++; else right--;
        }
        return best;
    }
}`,
          `class Solution {
    fun maxArea(height: IntArray): Int {
        var left = 0
        var right = height.lastIndex
        var best = 0
        while (left < right) {
            best = maxOf(best, (right - left) * minOf(height[left], height[right]))
            if (height[left] <= height[right]) left++ else right--
        }
        return best
    }
}`,
          `class Solution {
public:
    int maxArea(vector<int>& height) {
        int left = 0, right = (int)height.size() - 1, best = 0;
        while (left < right) {
            best = max(best, (right - left) * min(height[left], height[right]));
            if (height[left] <= height[right]) ++left; else --right;
        }
        return best;
    }
};`,
        ),
      ],
      tests: {
        schemaVersion: 1,
        mode: 'function',
        method: 'maxArea',
        parameterTypes: ['intArray'],
        returnType: 'int',
        cases: [
          { name: '典型多峰高度', args: [[1, 8, 6, 2, 5, 4, 8, 3, 7]], expected: 49 },
          { name: '只有两条线', args: [[1, 1]], expected: 1 },
          { name: '两端形成最优容器', args: [[4, 3, 2, 1, 4]], expected: 16 },
        ],
      },
    },
    {
      id: 15,
      slug: '3sum',
      title: '三数之和',
      studyTags: ['排序去重', '双指针', '固定一个数'],
      summary: '找出数组中所有由三个不同位置组成且元素和为零的不重复三元组。',
      insight: '排序后固定第一个数，剩余两数之和可以用相向双指针线性求出，同时在移动时完成去重。',
      pitfalls: ['结果按数值组合去重而不是按下标', '固定值大于零后可以提前结束', '命中答案后左右两端都要跳过重复值'],
      solutions: [
        makeSolution(
          'sort-two-pointers',
          '排序 + 双指针',
          '最优',
          '排序将三数关系转化为固定一数后的两数之和，并利用相邻相等元素去重。',
          ['先对数组排序', '枚举第一个元素并跳过重复值', '在右侧区间用左右指针寻找相反数并去重'],
          'O(n²)',
          'O(log n)',
          `class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> answer = new ArrayList<>();
        for (int first = 0; first < nums.length - 2; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) continue;
            if (nums[first] > 0) break;
            int left = first + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[first] + nums[left] + nums[right];
                if (sum < 0) left++;
                else if (sum > 0) right--;
                else {
                    answer.add(Arrays.asList(nums[first], nums[left], nums[right]));
                    int leftValue = nums[left], rightValue = nums[right];
                    while (left < right && nums[left] == leftValue) left++;
                    while (left < right && nums[right] == rightValue) right--;
                }
            }
        }
        return answer;
    }
}`,
          `class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        val answer = ArrayList<List<Int>>()
        for (first in 0 until nums.size - 2) {
            if (first > 0 && nums[first] == nums[first - 1]) continue
            if (nums[first] > 0) break
            var left = first + 1
            var right = nums.lastIndex
            while (left < right) {
                val sum = nums[first] + nums[left] + nums[right]
                when {
                    sum < 0 -> left++
                    sum > 0 -> right--
                    else -> {
                        answer.add(listOf(nums[first], nums[left], nums[right]))
                        val leftValue = nums[left]
                        val rightValue = nums[right]
                        while (left < right && nums[left] == leftValue) left++
                        while (left < right && nums[right] == rightValue) right--
                    }
                }
            }
        }
        return answer
    }
}`,
          `class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        vector<vector<int>> answer;
        for (int first = 0; first + 2 < (int)nums.size(); ++first) {
            if (first > 0 && nums[first] == nums[first - 1]) continue;
            if (nums[first] > 0) break;
            int left = first + 1, right = (int)nums.size() - 1;
            while (left < right) {
                int sum = nums[first] + nums[left] + nums[right];
                if (sum < 0) ++left;
                else if (sum > 0) --right;
                else {
                    answer.push_back({nums[first], nums[left], nums[right]});
                    int leftValue = nums[left], rightValue = nums[right];
                    while (left < right && nums[left] == leftValue) ++left;
                    while (left < right && nums[right] == rightValue) --right;
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
        method: 'threeSum',
        parameterTypes: ['intArray'],
        returnType: 'intListMatrix',
        cases: [
          { name: '包含两个不重复答案', args: [[-1, 0, 1, 2, -1, -4]], expected: [[-1, -1, 2], [-1, 0, 1]] },
          { name: '不存在零和三元组', args: [[0, 1, 1]], expected: [] },
          { name: '多个零只保留一个组合', args: [[0, 0, 0]], expected: [[0, 0, 0]] },
        ],
      },
    },
    {
      id: 19,
      slug: 'remove-nth-node-from-end-of-list',
      title: '删除链表的倒数第 N 个结点',
      studyTags: ['快慢指针', '固定间距', '虚拟头结点'],
      summary: '删除单链表中从末尾数第 n 个节点，并返回删除后的链表头节点。',
      insight: '让快指针先领先 n 步，再与慢指针同步移动，就能让慢指针停在待删除节点的前一个位置。',
      pitfalls: ['删除头节点时需要统一处理', '快慢指针的初始间距要从虚拟头结点计算', 'n 在有效范围内但链表可能只有一个节点'],
      solutions: [
        makeSolution(
          'fast-slow-pointers',
          '固定间距双指针',
          '最优',
          '虚拟头结点消除删除头节点的特判，两个指针保持 n 个节点的间距。',
          ['创建 dummy 并连接原链表', 'fast 先向前走 n 步', '同步移动到 fast 位于尾节点，再删除 slow 的下一个节点'],
          'O(L)',
          'O(1)',
          `class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode fast = dummy, slow = dummy;
        for (int step = 0; step < n; step++) fast = fast.next;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}`,
          `class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val dummy = ListNode(0)
        dummy.next = head
        var fast: ListNode? = dummy
        var slow: ListNode? = dummy
        repeat(n) { fast = fast?.next }
        while (fast?.next != null) {
            fast = fast?.next
            slow = slow?.next
        }
        slow?.next = slow?.next?.next
        return dummy.next
    }
}`,
          `class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        ListNode dummy(0, head);
        ListNode* fast = &dummy;
        ListNode* slow = &dummy;
        for (int step = 0; step < n; ++step) fast = fast->next;
        while (fast->next) {
            fast = fast->next;
            slow = slow->next;
        }
        slow->next = slow->next->next;
        return dummy.next;
    }
};`,
        ),
      ],
      tests: {
        schemaVersion: 1,
        mode: 'function',
        method: 'removeNthFromEnd',
        parameterTypes: ['listNode', 'int'],
        returnType: 'listNode',
        cases: [
          { name: '删除链表中间节点', args: [[1, 2, 3, 4, 5], 2], expected: [1, 2, 3, 5] },
          { name: '删除唯一节点', args: [[1], 1], expected: [] },
          { name: '删除尾节点', args: [[1, 2], 1], expected: [1] },
        ],
      },
    },
  ],
}
