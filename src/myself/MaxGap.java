package myself;

public class MaxGap {

	public static void main(String[] args) {

		int[] array = { -1, 0, 4, 4, 5 };

		System.out.println(GetMaxGap(array));

	}

	public static int GetMaxGap(int arry[]) {

		int  max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
		for (int i = 0; i < arry.length; i++) {
			min = Math.min(min, arry[i]);
			max = Math.max(max, arry[i]);
		}

		if (min == max) {
			return 0;
		}

		int[] mins = new int[arry.length + 1];
		int[] maxs = new int[arry.length + 1];
		// ����Ƿ�������
		boolean[] flag = new boolean[arry.length + 1];

		// ��Ͱ
		int len = arry.length;
		for (int i = 0; i < arry.length; i++) {
			// һ�������룬��ȷ��Ҫ�����λ��
			int position = (int)((arry[i] - min) * len / (max - min));
			if (!flag[position]) {
				mins[position] = arry[i];
				maxs[position] = arry[i];
				flag[position] = true;
			} else {
				mins[position] = mins[position] > arry[i] ? arry[i] : mins[position];
				maxs[position] = maxs[position] < arry[i] ? arry[i] : maxs[position];
			}

		}
		int i = 1;
		int maxgap = 0;
		int curMax = maxs[0];
		// ���Ҵ�
		while (i <= len) {
			if (flag[i]) {
				maxgap = Math.max(maxgap, mins[i] - curMax);
				curMax = maxs[i];
			}
			i++;
//			if (flag[i]) {
//				maxgap = Math.max(maxgap, mins[i] - curMin);
//				curMin = maxs[i];
//			}
//			i++;
		}

		return maxgap;

	}

}






