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
		
		int[] array = { 72, 33, 56, 81, 22, 65, 15, 99, 100 };

		System.out.println("排序前:" + SortUtil.printArray(array));
		System.out.println("排序后:" + SortUtil.printArray(array));
	}
}
