package demo;

import bean.SortUtil;

/** 
 * @ClassName: BubbleSortDemo 
 * @Description: 冒泡排序测试DEMO 
 * @author HongDa
 * @date 2018年9月21日 下午2:09:50 
 */
public class BubbleSortDemo {
	
	public static void main(String[] args){
		
		int[] array = {7,3,5,8,2,6,1,9,4};
		
		System.out.println("排序前:" + SortUtil.printArray(array));
		bubbleSort(array);
		System.out.println("排序后:" + SortUtil.printArray(array));
	}
	
	/**
	 * @Description 冒泡排序算法
	 * @author HongDa
	 * @version 1.1.0
	 * @date 2018年9月21日 下午3:08:31
	 * @param array
	 * @throws
	 */
	public static void bubbleSort(int[] array){
		
		if(array == null || array.length == 0)
			return;
		
		for(int i = 0; i < array.length; i++){
			for(int j = 0; j < array.length - 1 - i; j++){
				if(array[j] > array[j + 1]){
					int temp = array[j + 1];
					array[j + 1] = array[j];
					array[j] = temp;
				}
			}
		}
	}
}
