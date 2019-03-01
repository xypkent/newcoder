//package myself;
//
//public class a02_01BFPRT {
//
//    public static int[] getMinNumsByBFPRT(int[] array, int k) {
//        if (k < 1 || k > array.length) {
//            return array;
//        }
//        int minKth = getMinKthByBFPRT(array, k);
//        int[] res = new int[k];
//        int index = 0;
//        for (int i = 0; i != array.length; i++) {
//            if (array[i] < minKth) {
//                res[index++] = array[i];
//            }
//        }
//        while (index != res.length) {
//            res[index++] = minKth;
//        }
//        return res;
//    }
//
//    public static int getMinKthByBFPRT(int[] arr, int K) {
//        int[] copyArr = copyArray(arr);
//        return bfprt(copyArr, 0, copyArr.length - 1, K - 1);
//    }
//
//    public static int bfprt(int[] arr, int begin, int end, int i) {
//        if (begin == end) {
//            return arr[begin];
//        }
//        int pivot = getMedianOfMedians(arr, begin, end);
//        int[] pivotRange = partition(arr, begin, end, pivot);
//        if (i >= pivotRange[0] && i <= pivotRange[1]) {
//            return arr[i];
//        } else if (i < pivotRange[0]) {
//            return bfprt(arr, begin, pivotRange[0] - 1, i);
//        } else {
//            return bfprt(arr, pivotRange[1] + 1, end, i);
//        }
//    }
//
//    public static int getMedianOfMedians(int[] arr, int begin, int end) {
//        int sum = end - begin + 1;
//        int offset = sum % 5 == 0 ? 0 : 1;
//        int[] mArr = new int[sum / 5 + offset];
//        int i = 0;
//        while (i < mArr.length) {
//            int subBegin = begin + i * 5;
//            int subEnd = subBegin + 4;
//            mArr[i++] = getMedian(arr, subBegin, Math.min(end, subEnd));
//        }
//        return bfprt(mArr, 0, mArr.length - 1, mArr.length / 2);
//    }
//
//    public static int getMedian(int[] arr, int begin, int end) {
//        insertionSort(arr, begin, end);
//
//    }
//
//    public static void insertionSort(int[] arr, int begin, int end) {
//        for (int i = begin; i != end; i++) {
//
//        }
//    }
//
//    public static int[] copyArray(int[] arr) {
//        int[] res = new int[arr.length];
//        for (int i = 0; i != res.length; i++) {
//            res[i] = arr[i];
//        }
//        return res;
//    }
//
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
