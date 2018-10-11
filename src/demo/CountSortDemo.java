package demo;

import bean.SortUtil;

/** 
 * @ClassName: CountSortDemo 
 * @Description: 计数排序测试DEMO 
 * @author HongDa
 * @date 2018年9月26日 下午3:21:01 
 */
public class CountSortDemo {
	public static void main(String[] args){
		
//		int[] array = { 7, 7, 3, 8, 6, 2, 2, 9, 4 };
		int[] array = { 7, 3, 5, 8, 2, 6, 1, 9, 4 };

		System.out.println("排序前:" + SortUtil.printArray(array));
		array = countSort(array);
		System.out.println("排序后:" + SortUtil.printArray(array));
	}
	
	/**
	 * @Description 计数排序算法
	 * @author HongDa
	 * @version 1.1.0
	 * @date 2018年9月26日 下午5:36:55
	 * @param array
	 * @return
	 * @throws
	 */
	public static int[] countSort(int[] array){
		
		if(array == null || array.length == 0)
			return null;
		
		int[] b = new int[array.length];
		int max = array[0],min = array[0];
		
		//计算出用来存放计数值的临时数组C[k]的大小k=max-min+1
		for(int a : array){
			
			if(a > max){
				max = a;
			}
			
			if(a < min){
				min = a;
			}
		}
		
		int[] c = new int[max - min + 1];
		
		//计算出min到max之间的数值在A[n]中出现的次数,并存到C[K]中
		for(int i = 0; i < array.length; i++){
			//计算A[n]中元素对应C[k]中索引位置
			int index = array[i] - min;
			//计算A[n]的元素出现的次数
			c[index] = c[index] + 1;
		}
		
		//计算A[n]中的元素应该出现在最终序列的位置,并存入C[k]中
		for(int i = 1; i < c.length; i++){
			c[i] = c[i] + c[i - 1];
		}
		
		//按照C[k]中存储的元素出现的位置将A[n]中的元素放入B[n]中
		for(int i = array.length - 1; i >= 0; i--){
			int index = array[i] - min;
			c[index] = c[index] - 1;
			b[c[index]] = array[i];
		}
		
		return b;
	}
}
