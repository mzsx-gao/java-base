package gao.javabase.algorithm.leetcode.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author  gaosd
 * @description ：(LeetCode-406) 根据身高重建队列
 * 假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。
 * 每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。
 * 请你重新构造并返回输入数组 people 所表示的队列。返回的队列应该格式化为数组 queue ，
 * 其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。
 */
public class QueueReconstruction_406 {

    public int[][] reconstructQueue(int[][] people) {
        /**
         * 按照身高h从大到小排列,如果身高h一样就按照属性k从小到大排序
         * 就需要自定义排序方法，每个o1和o2元素都是只有两个元素的数组
         * 0号元素代表身高h，1号元素代表前面人数k
         */
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o2[0] - o1[0];
            } else {
                return o1[1] - o2[1];
            }
        });
        /**
         * 遍历排序后的people数组
         * {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}}
         * 加入answer时对每一个元素插入k属性所指定的索引处，完成遍历后
         * answer变为
         * {{5,0},{7,0},{5,2},{6,1},{4,4},{7,1}}
         */
        List<int[]> answer = new ArrayList<>();
        for (int[] element : people) {
            answer.add(element[1], element);
        }
        return answer.toArray(new int[answer.size()][]);
    }

    public static void main(String[] args) {
        int[][] people = new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        new QueueReconstruction_406().reconstructQueue(people);
    }
}
