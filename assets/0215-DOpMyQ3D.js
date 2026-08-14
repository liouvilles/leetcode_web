const h=215,t="kth-largest-element-in-an-array",n="Kth Largest Element in an Array",f="中等",i="数据结构与设计",e=["数组","分治","排序","堆（优先队列）","快速选择"],g=!1,a="https://leetcode.cn/problems/kth-largest-element-in-an-array/",r="数组中的第 K 个最大元素",o=["Top K","小顶堆","Quickselect"],s="在未排序数组中找到按大小排序后的第 k 个元素，重复值按出现次数计算。",l="只关心最大的 k 个数时无需完全排序；固定容量的小顶堆或快速选择都能缩小工作量。",p=["第 k 大对应升序下标 n-k","重复元素不能去重","快速选择的平均与最坏复杂度不同"],u=[{id:"min-heap",title:"容量为 K 的小顶堆",kind:"进阶",idea:"堆中始终保留目前最大的 k 个元素，堆顶就是其中最小者。",steps:["把元素加入小顶堆","容量超过 k 时弹出堆顶","扫描结束后返回堆顶"],complexity:{time:"O(n log k)",space:"O(k)"},code:{java:`class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int num : nums) {
            heap.offer(num);
            if (heap.size() > k) heap.poll();
        }
        return heap.peek();
    }
}
`,kotlin:`class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val heap = java.util.PriorityQueue<Int>()
        for (num in nums) {
            heap.offer(num)
            if (heap.size > k) heap.poll()
        }
        return heap.peek()
    }
}
`,cpp:`class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        priority_queue<int, vector<int>, greater<int>> heap;
        for (int num : nums) {
            heap.push(num);
            if ((int)heap.size() > k) heap.pop();
        }
        return heap.top();
    }
};
`}},{id:"quickselect",title:"随机快速选择",kind:"最优",idea:"利用分区操作只进入目标下标所在的一侧，不必把两侧都排好序。",steps:["把第 k 大换算为升序目标下标 n-k","随机选择枢轴并分区","根据枢轴位置缩小搜索边界"],complexity:{time:"平均 O(n)，最坏 O(n²)",space:"O(1)"},code:{java:`class Solution {
    private final Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        int target = nums.length - k, left = 0, right = nums.length - 1;
        while (left <= right) {
            int pivot = partition(nums, left, right);
            if (pivot == target) return nums[pivot];
            if (pivot < target) left = pivot + 1; else right = pivot - 1;
        }
        throw new IllegalStateException();
    }

    private int partition(int[] a, int left, int right) {
        int pick = left + random.nextInt(right - left + 1);
        swap(a, pick, right);
        int store = left;
        for (int i = left; i < right; i++) if (a[i] < a[right]) swap(a, store++, i);
        swap(a, store, right);
        return store;
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i]; a[i] = a[j]; a[j] = temp;
    }
}
`,kotlin:`class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val target = nums.size - k
        var left = 0
        var right = nums.lastIndex
        while (left <= right) {
            val pivot = partition(nums, left, right)
            when {
                pivot == target -> return nums[pivot]
                pivot < target -> left = pivot + 1
                else -> right = pivot - 1
            }
        }
        error("unreachable")
    }

    private fun partition(a: IntArray, left: Int, right: Int): Int {
        val pick = kotlin.random.Random.nextInt(left, right + 1)
        a[pick] = a[right].also { a[right] = a[pick] }
        var store = left
        for (i in left until right) {
            if (a[i] < a[right]) a[store] = a[i].also { a[i] = a[store++] }
        }
        a[store] = a[right].also { a[right] = a[store] }
        return store
    }
}
`,cpp:`class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        int target = nums.size() - k, left = 0, right = nums.size() - 1;
        while (left <= right) {
            int pivot = partition(nums, left, right);
            if (pivot == target) return nums[pivot];
            if (pivot < target) left = pivot + 1; else right = pivot - 1;
        }
        return -1;
    }

private:
    int partition(vector<int>& a, int left, int right) {
        int pick = left + rand() % (right - left + 1);
        swap(a[pick], a[right]);
        int store = left;
        for (int i = left; i < right; ++i) if (a[i] < a[right]) swap(a[store++], a[i]);
        swap(a[store], a[right]);
        return store;
    }
};
`}}],c={id:215,slug:t,titleEn:n,difficulty:"中等",category:i,officialTags:e,paidOnly:!1,sourceUrl:a,title:r,studyTags:o,summary:s,insight:l,pitfalls:p,solutions:u};export{i as category,c as default,f as difficulty,h as id,l as insight,e as officialTags,g as paidOnly,p as pitfalls,t as slug,u as solutions,a as sourceUrl,o as studyTags,s as summary,r as title,n as titleEn};
