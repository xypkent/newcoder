package class_05;

public class c05_03BloemFilter {

    //实现0~m-1比特的数组
    public static void main(String[] args) {
        //int 4个字节 32个比特
        int[] arr = new int[1000];//4*8*1000 = 32000;

        //数量不够可以使用二维数组实现
        long[][] map = new long[1000][1000];

        int index = 30000;//想把第30000位置描黑

        int intIndex = index / 4 / 8;//查看这个bit来自哪个整数位置

        int bitIndex = index % 32;//在定位来自这个整数的哪个bit位

        arr[intIndex] = arr[intIndex] | (1 << bitIndex);
    }

}
