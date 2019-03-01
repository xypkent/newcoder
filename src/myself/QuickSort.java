package myself;

public class QuickSort {

	public static void main(String[] args) {

		int[] test = { 1, 2, 4, 7, 2, 3, 4, 6, 8 };
		// int[] test = { 1, 3, 5, 2, 7, 6, 2 };

		MainQuickSort(test, 0, test.length - 1);

		for (int i : test) {
			System.out.print(i + " ");
		}

	}

	public static void MainQuickSort(int[] arry, int l, int r) {
		if (l < r) {
			swap(arry, (int) (Math.random() * (r - l + 1)) + l , r);
			int[] middle = GoQuickSort(arry, l, r);
			MainQuickSort(arry, l, middle[0] - 1);
			MainQuickSort(arry, middle[1] + 1, r);
		}
	}

	public static int[] GoQuickSort(int[] arry, int l, int r) {

		int less = l - 1;
		int more = r;

		while (l < more) {
			if (arry[l] < arry[r]) {
				swap(arry, ++less, l++);
			} else if (arry[l] > arry[r]) {
				swap(arry, --more, l);
			} else {// 相等的情况
				l++;
			}
		}
		swap(arry, more, r);
		// System.out.println(more);

		return new int[] { less + 1, more };

	}

	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

}
