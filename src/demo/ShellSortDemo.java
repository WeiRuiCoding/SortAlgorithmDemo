package demo;

import bean.SortUtil;

/** 
 * @ClassName: ShellSortDemo 
 * @Description: 希尔排序测试案例 
 * @author HongDa
 * @date 2018年9月26日 上午11:19:29 
 */
public class ShellSortDemo {
	public static void main(String[] args){
		
		int[] array = { 7, 5, 3, 8, 6, 2, 1, 9, 4 };

		System.out.println("排序前:" + SortUtil.printArray(array));
		shellSort(array);
		System.out.println("排序后:" + SortUtil.printArray(array));
	}
	
	/**
	 * @Description 希尔排序算法
	 * @author HongDa
	 * @version 1.1.0
	 * @date 2018年9月26日 下午3:02:04
	 * @param array
	 * @throws
	 */
	public static void shellSort(int[] array){
		
		if(array == null || array.length == 0)
			return;
		
		int step = array.length;
		
		while(step != 1){
			
			step = step / 2;
			
			//控制每一次增量的多个分组循环,每一个分组进行插入排序
			for(int k = 0; k < step; k++){
				//对一个分组中待排序序列中的元素进行排序
				for(int i = k + step; i < array.length; i = i + step){
					
					int key = array[i];
					int j;
					
					//循环已排序序列,将比key大的值后移
					for(j = i - step; j >= 0 && array[j] > key; j = j - step){
						array[j + step] = array[j];
					}
					
					array[j + step] = key;
				}
			}
		}
	}
}
