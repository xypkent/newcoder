package myself;

public class MergeSort {

	// public int reverse(int[] array, int l, int r) {
	//
	// if (l == r) {
	// return 0;
	// }
	//
	// return 0;
	// }

	public static int res = 0;

	public static void main(String[] args) {
//		 int[] test = { 1, 2, 4, 7, 2, 3, 4, 6, 8 };
		int[] test = { 1, 3, 4, 2, 5 };

		mergesort(test, 0, test.length - 1);

		for (int i : test) {
			System.out.print(i + " ");
		}

		System.out.println("小和问题" + res);
	}

	public static void mergesort(int[] array, int l, int r) {

		if (l == r)
			return;

		int mid = (l + r) >> 1;
		mergesort(array, l, mid);
		mergesort(array, mid + 1, r);
		// 合并操作
		merge(array, l, mid, r);
	}

	private static void merge(int[] array, int l, int mid, int r) {

		int[] help = new int[r - l + 1];
		int p1 = l;
		int p2 = mid + 1;

		int i = 0;

		while (p1 <= mid && p2 <= r) {
			res += array[p1] < array[p2] ? array[p1] * (r - p2 + 1) : 0;
			help[i++] = array[p1] > array[p2] ? array[p2++] : array[p1++];
		}

		while (p1 <= mid) {
			help[i++] = array[p1++];
		}
		while (p2 <= r) {
			help[i++] = array[p2++];
		}

		for (int j = 0; j < help.length; j++) {
			array[l + j] = help[j];
		}

	}
}
