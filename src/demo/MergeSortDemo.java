package demo;

import bean.SortUtil;

/**
 * @ClassName: MergeSortDemo
 * @Description: 归并排序测试DEMO
 * @author HongDa
 * @date 2018年9月25日 下午2:14:53
 */
public class MergeSortDemo {

	public static void main(String[] args) {

		int[] array = { 7, 5, 3, 8, 6, 2, 1, 9, 4 };

		System.out.println("排序前:" + SortUtil.printArray(array));
		mergeSort(array, 0, array.length - 1);
		System.out.println("排序后:" + SortUtil.printArray(array));
	}
	
	/**
	 * @Description 归并排序算法
	 * @author HongDa
	 * @version 1.1.0
	 * @date 2018年9月25日 下午2:16:27
	 * @throws
	 */
	public static int[] mergeSort(int[] array, int low, int high) {
		
		int mid = (low + high) / 2;
		
		if(low < high){
			//左边部分归并
			mergeSort(array, low, mid);
			//右边部分归并
			mergeSort(array, mid + 1, high);
			//左右部分归并
			merge(array, low, mid, high);
		}
		
		return array;
	}
	
	/**
	 * @Description 归并操作
	 * @author HongDa
	 * @version 1.1.0
	 * @date 2018年9月25日 下午4:07:29
	 * @param a
	 * @param low
	 * @param mid
	 * @param high
	 * @throws
	 */
	public static void merge(int[] array, int low, int mid, int high) {
		
		int[] temp = new int[high - low + 1];
		
		int i = low;
		int j = mid + 1;
		int k = 0;
		
		//分别从两个虚拟序列A[i],B[j]中按顺序插入到临时数组中
		while(i <= mid && j <= high){
			if(array[i] < array[j]){
				temp[k++] = array[i++];
			}else{
				temp[k++] = array[j++];
			}
		}
		
		//将A[i]中多余元素放入临时数组中
		while(i <= mid){
			temp[k++] = array[i++];
		}
		
		//将B[j]中多余元素放入临时数组中
		while(j <= high){
			temp[k++] = array[j++];
		}
		
		//将临时数组中元素原位置覆盖至原数组中
		for(int x = 0; x < temp.length; x++){
			array[low + x] = temp[x];
		}
	}
}
