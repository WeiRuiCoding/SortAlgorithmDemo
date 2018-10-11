package demo;

import bean.SortUtil;

/** 
 * @ClassName: DirectInsertSortDemo 
 * @Description: 直接插入排序DEMO 
 * @author HongDa
 * @date 2018年9月25日 下午5:49:45 
 */
public class DirectInsertSortDemo {
	public static void main(String[] args){
		
		int[] array = {7,3,5,8,2,6,1,9,4};
		
		System.out.println("排序前:" + SortUtil.printArray(array));
		directInsertSort(array);
		System.out.println("排序后:" + SortUtil.printArray(array));
	}
	
	/**
	 * @Description 直接插入排序算法
	 * @author HongDa
	 * @version 1.1.0
	 * @date 2018年9月25日 下午6:01:18
	 * @param array
	 * @throws
	 */
	public static void directInsertSort(int[] array){
		
		if(array == null || array.length == 0)
			return;
		
		int length = array.length;
		int key;//待排序的关键元素
		int j;
		
		//外层循环控制待排序的无序序列array[1]-array[n-1]
		for(int i = 1; i < length; i++){
			
			key = array[i];
			j = i-1;
			
			//将大于key的元素向后移动
			for(;j >= 0 && array[j] > key; j--){
				array[j+1] = array[j];
			}
			
			array[j+1] = key;
		}
	}
}
