package demo;

import bean.SortUtil;

/** 
 * @ClassName: QuickSortDemo 
 * @Description: 快速排序测试DEMO
 * @author HongDa
 * @date 2018年9月25日 下午1:54:48 
 */
public class QuickSortDemo {
	public static void main(String[] args){
		
		int[] array = {7,5,5,8,6,6,1,9,4};
		
		System.out.println("排序前:" + SortUtil.printArray(array));
		quickSort(array, 0, array.length - 1);
		System.out.println("排序后:" + SortUtil.printArray(array));
	}
	
	/**
	 * @Description 快速排序算法
	 * @author HongDa
	 * @version 1.1.0
	 * @date 2018年9月25日 下午2:16:02
	 * @param array
	 * @param start
	 * @param end
	 * @throws
	 */
	public static void quickSort(int[] array,int start,int end){
		
		if(array == null || array.length == 0)
			return;
		
		int i = start,j = end,key = array[i];
		
		while(i < j){
			
			//从后向前搜索找到比key小的值
			while(i < j && array[j] > key){
				j--;
			}
			
			if(i < j){
				array[i] = array[j];
				i++;
			}
			
			//从前向后搜索找到比key大的值
			while(i < j && array[i] < key){
				i++;
			}
			
			if(i < j){
				array[j] = array[i];
				j--;
			}
		}
		
		//i == j
		array[i] = key;
		
		//对小于key的部分进行快排
		if(i > start){
			quickSort(array, start, i -1);
		}
		
		//对大于key的部分进行快排
		if(j + 1 < end){
			quickSort(array, j + 1, end);
		}
	}
	
}
