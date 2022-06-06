package gao.javabase.algorithm.leetcode.array.phase3;

import java.util.*;

/**
 * @author  gaosd
 * @description ：(LeetCode-15) 三数之和
 * 给你一个包含 n 个整数的数组 nums，
 * 判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
 * 请你找出所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 */
public class ThreeSum_15 {

    /*暴力求解：排序+三重循环*/
    public List<List<Integer>> threeSum3Loop(int[] nums) {
        List<List<Integer>> results = new LinkedList<>();
        if(nums.length < 3) return results; //长度小于3,就不存在三数之和了
        //排序
        Arrays.sort(nums);
        //如果第一个数就大于0，那就没必要再查找下去了
        if(nums[0] > 0) return results;
        for(int i = 0; i < nums.length - 2; i++){
            int x = nums[i];
            if(x > 0) break;
            //去重，假如给的用例是[0, 0, 0, 0],当i第一次遇到0时，为首次遇见没有关系，可如果这次i的循环结束了
            //i+1进入第二次循环，那么这时候还是遇到0，为连续的第二次遇见，这就造成了前后重复，必须要跳过
            if(i > 0 && nums[i - 1] == nums[i]) continue;
            for(int j = i + 1; j < nums.length - 1; j++){
                int y = nums[j];
                //去重原理同i
                if(j > i + 1 && nums[j - 1] == nums[j]) continue;
                for(int k = j + 1; k < nums.length; k++){
                    int z = nums[k];
                    if(k > j + 1 && nums[k - 1] == nums[k]) continue;  //去重原理同j
                    if(x + y + z == 0){
                        List<Integer> list = new LinkedList<Integer>();
                        list.add(x);
                        list.add(y);
                        list.add(z);
                        results.add(list);
                    }
                }
            }
        }
        return results;
    }

    /*排序 + 两重循环 + HashMap*/
    public List<List<Integer>> threeSumWithMap(int[] nums) {
        List<List<Integer>> results = new LinkedList<>();
        if(nums.length < 3) return results; //长度小于3,就不存在三数之和了
        //排序
        Arrays.sort(nums);
        //如果第一个数就大于0，那就没必要再查找下去了
        if(nums[0] > 0) return results;
        //用一个HashMap将所有的元素加进去，这里的keys是nums[i]，value是i
        //如果出现重复的key,那么新出现的value将会覆盖前面的一个value，
        // 用这个map来替代第三重循环
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }
        for(int i = 0; i < nums.length - 2; i++){
            int x = nums[i];
            //如果第一个数就大于0，那就没必要再查找下去了
            if(x > 0) break;
            //去重
            if(i > 0 && nums[i - 1] == nums[i]) continue;
            for(int j = i + 1; j < nums.length - 1; j++){
                int y = nums[j];
                if(x + y > 0) break;
                //去重
                if(j > i + 1 && nums[j - 1] == nums[j]) continue;
                //z为组合需要的那个值
                int z = 0 - x - y;
                //如果map集合里面有这个值，最重要的是要判断它的value（序号）是不是在i和j的后面
                //因为之前的第三重for循环的k是从j + 1开始的，所以它一定会大于j
                if(map.containsKey(z) && map.get(z) > j){
                    List<Integer> list = new LinkedList<Integer>();
                    list.add(x);
                    list.add(y);
                    list.add(z);
                    results.add(list);
                }
            }
        }
        return results;
    }

    /*排序 + 双指针解法*/
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new LinkedList<>();
        if(nums.length < 3) return results; //长度小于3,就不存在三数之和了
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            //如果第一个数就大于0，那就没必要再查找下去了
            if (nums[i] > 0) break;
            int head = i + 1, tail = n - 1;
            //head指针和tail指针相对而行，但必须保证head在tail的左边
            while (head < tail) {
                //三数之和有三种情况：大于0，小于0，等于0
                int sum = nums[i] + nums[head] + nums[tail];
                if (sum < 0) head++; //三数之和小于0，左边head的那个数太小了，要把它向右移
                else if (sum > 0) tail--;//三数之和大于0，tail坐标的那个数太大了，要把它向左移
                else {
                    //三数之和等于0，添加到返回列表里面，并且同时将左指针右移，右指针左移，探索下一组适合的数据
                    List<Integer> list = new LinkedList<>();
                    list.add(nums[i]);
                    list.add(nums[head]);
                    list.add(nums[tail]);
                    results.add(list);
                    //去重
                    while (head+1 <= tail && nums[head] == nums[head+1]) head++;
                    while (head+1 <= tail && nums[tail] == nums[tail-1]) tail--;
                    head++;
                    tail--;
                }
            }
            //去重
            while (i+1 < n && nums[i+1] == nums[i]) i++;
        }
        return results;
    }

}
