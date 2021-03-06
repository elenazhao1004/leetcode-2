package leetcode.digui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,1,2]
 * 输出:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 * <p>
 * 来源：力扣（LeetCode）  47
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class N047PermuteUnique {
    public static void main(String[] args) {
        int[] nums = {1,1,3};
        new N047PermuteUnique().permuteUnique(nums);

    }

    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return lists;
        }
        Arrays.sort(nums);
        process(nums, 0);
        return lists;

    }

    private void process(int[] nums, int start) {
        if (start == nums.length) {
            List<Integer> list = new ArrayList<Integer>();
            for (int num : nums) {
                list.add(num);
            }
            lists.add(new ArrayList<>(list));
            return;
        }

        HashSet<Integer>set = new HashSet<>();  //保存当前要交换的位置已经有过哪些数字了
        for (int i = start; i < nums.length; i++) {
            if (set.contains(nums[i])) {   //如果存在了就跳过，不去交换
                continue;
            }
            set.add(nums[i]);
            swap(nums, start, i);
            //这里是start+1
            process(nums, start + 1);
            swap(nums, start, i);
        }
    }


    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
