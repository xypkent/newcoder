package class_08;

public class Code_02_Hanoi {

    public static void hanoi(int n) {
        if (n > 0) {
            func(n, n, "left", "mid", "right");
        }
    }

    public static void func(int rest, int down, String from, String help, String to) {
        if (rest == 1) {
            System.out.println("move " + down + " from " + from + " to " + to);
        } else {
            func(rest - 1, down - 1, from, to, help);
            func(1, down, from, help, to);
            func(rest - 1, down - 1, help, from, to);
        }
    }

    //课堂上的代码
    //N 表示当前是 1~N的问题
    //一开始都在from上
    public static void process(int N, String from, String to, String help) {
        if (N == 1) {//就只有一个了，可以直接移动
            System.out.println("Move 1 from " + from + " to " + to);
        } else {//否则就是1~N的问题
            process(N - 1, from, help, to);//把1~N-1个从from移动到help
            System.out.println("Move " + N + " from " + from + " to " + to);//单独把N移动到to
            process(N - 1, help, to, from);//第三步是挪回来,把在help上的挪到to
        }
    }

    public static void moveLeftToRight(int N) {
        if (N == 1) {
            System.out.println("move 1 from left to right");
        } else {
            moveLeftToMid(N - 1);//先把N-1移动到中间
            System.out.println("move " + N + "from left to right");//把N移动到目的地
            moveMidToRight(N - 1);//再把N-1移动到目的地
        }
    }

    public static void moveRightToLeft(int N) {

    }

    public static void moveLeftToMid(int N) {
        if (N == 1) {
            System.out.println("move 1 from left to mid");
        }
        moveLeftToRight(N - 1);
        System.out.println("move " + N + "from left to mid");
        moveRightToMid(N - 1);
    }

    public static void moveMidToLeft(int N) {

    }

    public static void moveRightToMid(int N) {

    }

    public static void moveMidToRight(int N) {
        if (N == 1) {
            System.out.println("move 1 from mid to right");
        }
        moveMidToLeft(N - 1);
        System.out.println("move " + N + "from mid to right");
        moveLeftToRight(N - 1);
    }

    public static void main(String[] args) {
        int n = 3;
        hanoi(n);
    }

}
