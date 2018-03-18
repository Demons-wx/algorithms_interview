package priorityqueue;

import java.util.*;

/**
 *
 * 给定一个非空数组，返回前k个出现频率最高的元素
 *
 * 例如：
 * 给定[1, 1, 1, 2, 2, 3], k = 2
 * 返回[1, 2]
 *
 * Created by wx
 * Date: 2018/2/23
 */
public class TopKFrequentElements {

    /**
     * 维护一个含有k个元素的优先队列。如果遍历到的元素比队列中的最小频率元素的频率高。
     * 则取出队列中最小频率的元素，将新元素入队
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> topKFrequent(int[] nums, int k) {

       // 统计每个元素出现的频率
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            Integer count = freq.get(nums[i]);
            if (count != null)
                freq.put(nums[i], count + 1);
            else
                freq.put(nums[i], 1);
        }

        // 扫描freq，维护当前出现频率最高的k个元素
        // 在优先队列中，按照频率排序，所以数据对是(频率，元素)的形式
//        PriorityQueue<FreqAndElem> pq = new PriorityQueue<FreqAndElem>(new Comparator<FreqAndElem>() {
//            public int compare(FreqAndElem o1, FreqAndElem o2) {
//                return o1.freq - o2.freq;
//            }
//        });
        PriorityQueue<FreqAndElem> pq = new PriorityQueue<>(Comparator.comparing(FreqAndElem::getFreq));

        Iterator<Map.Entry<Integer, Integer>> iter = freq.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<Integer, Integer> elem = iter.next();
            if (pq.size() == k) {
                if (elem.getValue() > pq.peek().freq) {
                    pq.poll();
                    pq.add(new FreqAndElem(elem.getValue(), elem.getKey()));
                }
            } else {
                pq.add(new FreqAndElem(elem.getValue(), elem.getKey()));
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.peek().elem);
            pq.poll();
        }

        return res;
    }

    class FreqAndElem {
        int freq;
        int elem;

        public FreqAndElem(int freq, int elem) {
            this.freq = freq;
            this.elem = elem;
        }

        public int getFreq() {
            return freq;
        }

        public void setFreq(int freq) {
            this.freq = freq;
        }

        public int getElem() {
            return elem;
        }

        public void setElem(int elem) {
            this.elem = elem;
        }
    }

    public static void main(String[] args) {

        int[] nums = {4,1,-1,2,-1,2,3};
        int k = 2;
        List<Integer> res = new TopKFrequentElements().topKFrequent(nums, k);
        System.out.println(res);
    }
}
