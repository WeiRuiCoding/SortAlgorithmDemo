package demo;

import bean.SortUtil;

/**
 * @ClassName: TestSortDemo
 * @Description: 测试排序算法DEMO
 * @author HongDa
 * @date 2018年9月25日 下午5:48:53
 */
public class TestSortDemo {
	public static void main(String[] args) {
		
//		int[] array = { 7, 3, 5, 8, 2, 6, 1, 9, 4 };
		int[] array = { 72, 33, 56, 81, 22, 65, 15, 99, 100 };

		System.out.println("排序前:" + SortUtil.printArray(array));
//		 bubbleSort(array);
//		 selectSort(array);
//		 quickSort(array, 0, array.length - 1);
//		 mergeSort(array, 0, array.length - 1);
//		 directInsertSort(array);
//		 shellSort(array);
//		 radixSort(array, 3);
//		 System.out.println("排序后:" + SortUtil.printArray(countSort(array)));
		System.out.println("排序后:" + SortUtil.printArray(array));
	}
}
