package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class T0239_Sliding_Window_Maximum {

    /**
     * 239. 滑动窗口最大值
     * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
     * 返回滑动窗口中的最大值。
     *
     * 进阶：
     * 你能在线性时间复杂度内解决此题吗？
     *
     * 示例:
     * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
     * 输出: [3,3,5,5,6,7]
     * 解释:
     *   滑动窗口的位置                最大值
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       3
     *  1 [3  -1  -3] 5  3  6  7       3
     *  1  3 [-1  -3  5] 3  6  7       5
     *  1  3  -1 [-3  5  3] 6  7       5
     *  1  3  -1  -3 [5  3  6] 7       6
     *  1  3  -1  -3  5 [3  6  7]      7
     *
     * 提示：
     * 1 <= nums.length <= 10^5
     * -10^4 <= nums[i] <= 10^4
     * 1 <= k <= nums.length
     */

    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] ans = new int[nums.length - k + 1];
        Deque<Integer> q = new LinkedList<>();

        for (int i = 0; i < nums.length; ++i) {
            while (!q.isEmpty() && i - q.getFirst() >= k) q.removeFirst();
            while (!q.isEmpty() && nums[i] >= nums[q.getLast()]) q.removeLast();
            q.addLast(i);
            if (i >= k - 1) ans[i - k + 1] = nums[q.getFirst()];
        }
        return ans;
    }

}