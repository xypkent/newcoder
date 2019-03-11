package advanced_class_05;

public class Code_05_Max_EOR {


    public static int getMaxEor1(int[] nums) {
        int maxEor = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int start = 0; start <= i; start++) {
                int curEor = 0;
                for (int k = start; k <= start; k++) {
                    curEor ^= nums[k];
                }
                Math.max(maxEor, curEor);
            }
        }
        return maxEor;
    }

    //记忆化搜索优化（利用之前的计算结果）
    public static int getMaxEor2(int[] nums) {
        int maxEor = Integer.MAX_VALUE;
        int[] dp = new int[nums.length];
        int eor = 0;
        for (int i = 0; i < nums.length; i++) {
            eor ^= nums[i];
            Math.max(maxEor,eor);
            for (int start = 0; start <= i; start++) {
                int curEor = eor ^ dp[start - 1];
                Math.max(maxEor,curEor);
            }
            dp[i] = eor;
        }
        return maxEor;
    }

    public static class Node {//前缀树节点
        public Node[] nexts = new Node[2];//只有两个路，0/1
    }

    public static class NumTrie {//前缀树
        public Node head = new Node();

        public void add(int num) {
            Node cur = head;
            //位移，整数是31位
            for (int move = 31; move >= 0; move--) {
                //提取出每个进制里面的数字
                //例如：0101 >> 3 = 0
                //在和1进行与运算
                //0 0 0 0
                //0 0 0 1
                //0 0 0 0 //取出了第一位为0
                int path = ((num >> move) & 1);
                //查看是否有路，没有就新建
                cur.nexts[path] = cur.nexts[path] == null ? new Node() : cur.nexts[path];
                cur = cur.nexts[path];
            }
        }

        //num 0~i eor结果，选出最优再返回
        public int maxXor(int num) {
            Node cur = head;
            int res = 0;
            for (int move = 31; move >= 0; move--) {
                int path = (num >> move) & 1;
                //如果考察符号位希望和path是一样的 1^1=0 0^0=0
                //其他位置，希望是相反的 1^0=1 0^1=1
                int best = move == 31 ? path : (path ^ 1);//期待
                best = cur.nexts[best] != null ? best : (best ^ 1);//实际
                //当前位的最优选择，左移当前位的数值后，加入结果(或一下)
                res |= (path ^ best) << move;//设置每一位的答案
                cur = cur.nexts[best];//下一层
            }
            return res;
        }

    }

    public static int maxXorSubarray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int eor = 0;
        NumTrie numTrie = new NumTrie();
        numTrie.add(0);//0和0异或
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];// 0 .. i
            //这个黑盒超好用
            //放入0~i eor，返回以i结尾下最大的异或和子数组的异或值
            max = Math.max(max, numTrie.maxXor(eor));
            numTrie.add(eor);
        }
        return max;
    }

    // for test
    public static int comparator(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int eor = 0;
            for (int j = i; j < arr.length; j++) {
                eor ^= arr[j];
                max = Math.max(max, eor);
            }
        }
        return max;
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 30;
        int maxValue = 50;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            int res = maxXorSubarray(arr);
            int comp = comparator(arr);
            if (res != comp) {
                succeed = false;
                printArray(arr);
                System.out.println(res);
                System.out.println(comp);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }
}
