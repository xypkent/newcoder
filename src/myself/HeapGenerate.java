package myself;

import java.util.Arrays;

public class HeapGenerate {

	// for test
		public static void comparator(int[] arr) {
			Arrays.sort(arr);
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
		public static int[] copyArray(int[] arr) {
			if (arr == null) {
				return null;
			}
			int[] res = new int[arr.length];
			for (int i = 0; i < arr.length; i++) {
				res[i] = arr[i];
			}
			return res;
		}

		// for test
		public static boolean isEqual(int[] arr1, int[] arr2) {
			if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
				return false;
			}
			if (arr1 == null && arr2 == null) {
				return true;
			}
			if (arr1.length != arr2.length) {
				return false;
			}
			for (int i = 0; i < arr1.length; i++) {
				if (arr1[i] != arr2[i]) {
					return false;
				}
			}
			return true;
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
			int testTime = 10;
			int maxSize = 100;
			int maxValue = 100;
			boolean succeed = true;
			for (int i = 0; i < testTime; i++) {
				int[] arr1 = generateRandomArray(maxSize, maxValue);
				int[] arr2 = copyArray(arr1);
				heapSort(arr1);
				comparator(arr2);
				if (!isEqual(arr1, arr2)) {
					succeed = false;
					break;
				}
			}
			System.out.println(succeed ? "Nice!" : "Fucking fucked!");

			int[] arr = generateRandomArray(maxSize, maxValue);
			printArray(arr);
			heapSort(arr);
			printArray(arr);
		}

	public static void heapSort(int[] arry){
		
		for (int i = 0; i < arry.length; i++) {
			heap(arry, i);
		}

		for (int size = arry.length-1; size >= 0;) {
			swap(arry, 0, size);
			heapify(arry, 0, size);
		}
		
	}
	
/*	public static void main(String[] args) {

		int[] arry = { 1, 5, 2, 3, 7 };

		for (int i = 0; i < arry.length; i++) {
			heap(arry, i);
		}

		for (int i : arry) {
			System.out.print(i + " ");
		}
		System.out.println("\n");
		for (int size = arry.length-1; size >= 0;) {
			swap(arry, 0, size);
			System.out.print(arry[size--]);
			heapify(arry, 0, size);
		}

	}*/

	private static void heapify(int[] arry, int index, int size) {
		int large = index;
		while (true) {
			//与左右孩子对比
			if (arry[large] < arry[index * 2 + 1]&&(index * 2 + 1) < size) {
				large = index * 2 + 1;
			}
			if (arry[large] < arry[index * 2 + 2]&&(index * 2 + 2) < size) {
				large = index * 2 + 2;
			}
			if(large == index){
				break;
			}
			swap(arry, large, index);
			large = index;
		}

	}

	public static void heap(int[] arry, int index) {
		while (arry[index] > arry[(index - 1) / 2]) {

			swap(arry, index, (index - 1) / 2);
			index = (index - 1) / 2;

			// int large = index;
			// //先和父亲对比
			// if (arry[index] > arry[(index -1)/2]) {
			// large = index;
			// }
			//
			// //下面和左右孩子对比
			// if (arry[index] < arry[index * 2 + 1]) {
			// large = index * 2 + 1;
			// }
			// if (arry[index * 2 + 1] < arry[index * 2 + 2]) {
			// large = index * 2 + 2;
			// }
		}

	}

	public static void swap(int[] arry, int x, int y) {
		int temp = arry[x];
		arry[x] = arry[y];
		arry[y] = temp;
	}

}
