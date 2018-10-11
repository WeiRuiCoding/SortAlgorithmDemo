package demo;

import bean.SortUtil;

/** 
 * @ClassName: SelectSortDemo 
 * @Description: 选择排序测试DEMO 
 * @author HongDa
 * @date 2018年9月21日 下午3:51:24 
 */
public class SelectSortDemo {
	
	public static void main(String[] args){
		
		int[] array = {7,3,5,8,2,6,1,9,4};
		
		System.out.println("排序前:" + SortUtil.printArray(array));
		selectSort(array);
		System.out.println("排序后:" + SortUtil.printArray(array));
	}
	
	/**
	 * @Description 选择排序算法
	 * @author HongDa
	 * @version 1.1.0
	 * @date 2018年9月21日 下午4:22:49
	 * @param array
	 * @throws
	 */
	public static void selectSort(int[] array){
		
		if(array == null || array.length == 0)
			return;
		
		for(int i = 0; i < array.length; i++){
			int min = i;
			
			for(int j = i; j < array.length - 1; j++){
				if(array[min] > array[j + 1]){
					min = j + 1;
				}
			}
			
			if(min != i){
				int temp = array[min];
				array[min] = array[i];
				array[i] = temp;
			}
		}
	}
}
