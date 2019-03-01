package myself;

public class a02_01BFPRT {

    public static int[] getMinNumsByBFPRT(int[] array, int k) {
        if (k < 1 || k > array.length) {
            return array;
        }
        int minKth = getMinKthByBFPRT(array, k);
        int[] res = new int[k];
        int index = 0;
        for (int i = 0; i != array.length; i++) {
            if (array[i] < minKth) {
                res[index++] = array[i];
            }
        }
        while (index != res.length) {
            res[index++] = minKth;
        }
        return res;
    }

    public static int getMinKthByBFPRT(int[] arr, int K) {
        int[] copyArr = copyArray(arr);
        return bfprt(copyArr, 0, copyArr.length - 1, K - 1);
    }

    public static int bfprt(int[] arr, int begin, int end, int i) {
        if (begin == end) {
            return arr[begin];
        }
        int pivot = getMedianOfMedians(arr, begin, end);
        int[] pivotRange = partition(arr, begin, end, pivot);
        if (i >= pivotRange[0] && i <= pivotRange[1]) {
            return arr[i];
        } else if (i < pivotRange[0]) {
            return bfprt(arr, begin, pivotRange[0] - 1, i);
        } else {
            return bfprt(arr, pivotRange[1] + 1, end, i);
        }
    }

    private static int[] partition(int[] arr, int begin, int end, int pivot) {
        int small = begin - 1;
        int big = end + 1;
        int cur = begin;
        while(cur != big){
            if (arr[cur] < pivot){
                swap(arr,++small,cur++);
            }else if (arr[cur] > pivot){
                swap(arr,--big,cur);
            }else{
                cur++;
            }
        }
        int[] range = new int[2];
        range[0] = small +1 ;
        range[1] = big -1;
        return range;
    }

    public static int getMedianOfMedians(int[] arr, int begin, int end) {
        int sum = end - begin + 1;
        int offset = sum % 5 == 0 ? 0 : 1;
        int[] mArr = new int[sum / 5 + offset];
        int i = 0;
        while (i < mArr.length) {
            int subBegin = begin + i * 5;
            int subEnd = subBegin + 4;
            mArr[i++] = getMedian(arr, subBegin, Math.min(end, subEnd));
        }
        return bfprt(mArr, 0, mArr.length - 1, mArr.length / 2);
    }

    public static int getMedian(int[] arr, int begin, int end) {
        insertionSort(arr, begin, end);
        int num = end + begin;
        int mid = num / 2 + num % 2;
        return arr[mid];
    }

    public static void insertionSort(int[] arr, int begin, int end) {
        for (int i = begin + 1; i != end + 1; i++) {
            for (int j = i; j != begin; j--) {
                if (arr[j - 1] > arr[j])
                    swap(arr, j - 1, j);
                else
                    break;
            }
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static int[] copyArray(int[] arr) {
        int[] res = new int[arr.length];
        for (int i = 0; i != res.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int[] arr = {6, 9, 1, 3, 1, 2, 2, 5, 6, 1, 3, 5, 9, 7, 2, 5, 6, 1, 9};
        // sorted : { 1, 1, 1, 1, 2, 2, 2, 3, 3, 5, 5, 5, 6, 6, 6, 7, 9, 9, 9 }
        printArray(getMinNumsByBFPRT(arr, 10));

    }

}



















