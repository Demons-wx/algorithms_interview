package queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * 给出一个正整数n，寻找最少的完全平方数，使他们的和为n
 * 完全平方数：1, 4, 9, 16...
 * 示例：
 * 12 = 4 + 4 + 4
 * 13 = 4 + 9
 * 备注：此问题不能用贪心算法解决
 *
 * Created by wx
 * Date: 2018/2/6
 */
public class PerfectSquares {

    /**
     * 对问题建模：
     * 整个问题转化为一个图论问题。
     * 从n到0，每个数字表示一个节点，如果两个数字x到y相差一个完全平方数，则连接一条边，
     * 我们将得到一个无权图，原问题转化为，求这个无权图中从n到0的最短路径
     *
     * 解决这个问题的最佳方案就是广度优先遍历
     * @param n
     * @return
     */
    public int numSquares(int n) {

        Queue<NumAndStep> q = new LinkedList<NumAndStep>();
        q.offer(new NumAndStep(n, 0));

        boolean[] visited = new boolean[n + 1];
        visited[n] = true;

        while (!q.isEmpty()) {
            int num = q.peek().num;
            int step = q.peek().step;
            q.poll();

            for (int i = 1; ; i++) {

                int cur = num - i * i;
                if (cur < 0)
                    break;

                if (cur == 0)
                    return step + 1;

                if (!visited[num - i * i]) {
                    q.offer(new NumAndStep(num - i * i, step + 1));
                    visited[num - i * i] = true;
                }
            }

        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new PerfectSquares().numSquares(9));
    }

    private class NumAndStep {
        int num;
        int step;

        public NumAndStep(int num, int step) {
            this.num = num;
            this.step = step;
        }
    }
}

//num = 9
//
//i = 1
//9 - 1 * 1 = 8 >= 0
//q = [(8, 1)] 表示9到8只需要1步
//
//i = 2
//9 - 2 * 2 = 5 >= 0
//q = [(8, 1), (5, 1)]
//
//i = 3
//9 - 3 * 3 = 0 >= 0
//q = [(8, 1), (5, 1), (0, 1)]
//9到0也只需要一步,跳出循环,返回1


//num = 8
//
//i = 1
//8 - 1 * 1 = 7 >= 0
//q = [(7, 1)]
//
//i = 2
//8 - 2 * 2 = 4 >= 0
//q = [(7, 1), (4, 1)]
//
//i = 3
//8 - 3 * 3 = -1 < 0 跳出for循环
//
//弹出(7, 1)
//num = 7 step = 1
//
//i = 1
//7 - 1 * 1 = 6 >= 0
//q = [(4, 1), (6, 2)]
//
//i = 2
//7 - 2 * 2 = 3 >= 0
//q = [(4, 1), (6, 2), (3, 2)]
//
//i = 3
//7 - 3 * 3 = -2 < 0 跳出for循环
//
//弹出(4, 1)
//num = 4 step = 1
//
//i = 1
//4 - 1 * 1 = 3 >= 0
//q = [(6, 2), (3, 2), (3, 2)] 重复元素会进行判断，所以第二个(3, 2)是不会进入队列的，此处为了逻辑清晰展示
//
//i = 2
//4 - 2 * 2 = 0 >= 0
//q = [(6, 2), (3, 2), (3, 2), (0, 2)]
//
//栈前面的几对元素会相继弹出，直到遇到(0, 2)，表示8到0需要两步，return 2


